<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="questionarioDetail.title"/></title>
<content tag="heading"><fmt:message key="questionarioDetail.heading"/></content>

<form method="post" action="<c:url value="/editQuestionario.html"/>" id="questionarioForm"
    onsubmit="return validatequestionario(this)">

<table class="detail">
<c:if test="${questionarioFormulario.questionario.questoes != null}">
  <tr>
    <td></td>
    <td class="buttonBar">  
        <input type="submit" class="button" name="save"
            onclick="bCancel=false" value="<fmt:message key="button.save"/>" />          
        <input type="submit" class="button" name="cancel" 
            onclick="bCancel=true" value="<fmt:message key="button.cancel"/>" />
    </td>
  </tr>
  
	<c:forEach var="questaoItem" items="${questionarioFormulario.questionario.questoes}"	varStatus="statusQuestoes">
  <tr><td>&nbsp;
    <input type="hidden" name="<c:out value="${questaoItem.id}"/>" value="<c:out value="${status.value}"/>"/>
    </td></tr>
  <tr>
      <td colspan="3">
              <c:out value="${questaoItem.pergunta}"/>
              <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
      </td>
  </tr>
    <c:if test="${questaoItem.respostas != null}">
    	<c:forEach var="list" items="${questaoItem.respostas}"	varStatus="statusRespostas">
  <tr>
      <td colspan="3">
          <input type="radio" name="questao<c:out value="${questaoItem.id}"/>" id="questao<c:out value="${questaoItem.id}"/>" 
              value="<c:out value="${list.id}"/>"/>
          <c:out value="${list.conteudo}"/>
      </td>
  </tr>
    	</c:forEach>
    </c:if> 
	</c:forEach>
  <tr>
    <td></td>
    <td class="buttonBar">  
        <input type="submit" class="button" name="save"
            onclick="bCancel=false" value="<fmt:message key="button.save"/>" />          
        <input type="submit" class="button" name="cancel" 
            onclick="bCancel=true" value="<fmt:message key="button.cancel"/>" />
    </td>
  </tr>
</c:if> 
</table>


</form>

<script type="text/javascript">
    Form.focusFirstElement(document.forms["questionarioForm"]);
</script>

<v:javascript formName="questionarioForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript"  src="<c:url value="/scripts/validator.jsp"/>"></script>
