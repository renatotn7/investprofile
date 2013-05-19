<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="acaoDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='acaoDetail.heading'/>"/>
</head>

<form:form commandName="acao" method="post" action="acaoform.html" id="acaoForm">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="id"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="acao.codigoBovespa"/>
        <form:errors path="codigoBovespa" cssClass="fieldError"/>
        <form:input path="codigoBovespa" id="codigoBovespa" cssClass="text medium"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="acao.codigoADR"/>
        <form:errors path="codigoADR" cssClass="fieldError"/>
        <form:input path="codigoADR" id="codigoADR" cssClass="text medium"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="acao.nome"/>
        <form:errors path="nome" cssClass="fieldError"/>
        <form:input path="nome" id="nome" cssClass="text medium"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="acao.segmento"/>
        <form:errors path="segmento" cssClass="fieldError"/>
          <form:select path="segmentos">
              <form:option value="-" label="--Please Select"/>
              <form:options items="${segmentos}" itemValue="code" itemLabel="name"/>
          </form:select>
    </li>    
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty acao.id}">
        <input type="submit" class="button" name="delete" onclick="return confirmDelete('acao')" 
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('acaoForm'));
</script>