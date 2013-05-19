<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="perfilInvestimentoDetail.title"/></title>
<content tag="heading"><fmt:message key="perfilInvestimentoDetail.heading"/></content>

<spring:bind path="perfilInvestimento.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">    
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<form method="post" action="<c:url value="/perfilinvestimentoform.html"/>" id="perfilInvestimentoForm"
    onsubmit="return validateperfilInvestimento(this)">
<table class="detail">

<spring:bind path="perfilInvestimento.id">
<input type="hidden" name="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/> 
</spring:bind>
    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.nome"/>
        </th>
        <td colspan="3">
            <spring:bind path="perfilInvestimento.nome">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" />
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.objetivo"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.objetivo">
        			<select name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" size="1">
    					<c:if test="${availableObjetivos != null}">
        				<c:forEach var="list" items="${availableObjetivos}" varStatus="statusObjetivos">
            			<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == status.value}">selected</c:if>>
                		<c:out value="${list.label}" escapeXml="false" />
            			</option>
        				</c:forEach>
    					</c:if>
        			</select> 
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
        <th>
            <investprofile:label key="perfilInvestimento.rendimentoEsperado"/>
        </th>        
        <td>
            <spring:bind path="perfilInvestimento.rendimentoEsperado">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" /> %
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.prazo"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.prazo">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" />
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
            <spring:bind path="perfilInvestimento.tipoPrazo">
        			<select name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" size="1">
    					<c:if test="${availableTempos != null}">
        				<c:forEach var="list" items="${availableTempos}" varStatus="statusTempos">
            			<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == status.value}">selected</c:if>>
                		<c:out value="${list.label}" escapeXml="false" />
            			</option>
        				</c:forEach>
    					</c:if>  
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
        <th>
            <investprofile:label key="perfilInvestimento.tempo"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.tempo">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" />
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
            <spring:bind path="perfilInvestimento.tipoTempo">
        			<select name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" size="1">
    					<c:if test="${availableTempos != null}">
        				<c:forEach var="list" items="${availableTempos}" varStatus="statusTempos">
            			<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == status.value}">selected</c:if>>
                		<c:out value="${list.label}" escapeXml="false" />
            			</option>
        				</c:forEach>
    					</c:if>  
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.liquidez"/>
        </th>
        <td colspan="3">
            <spring:bind path="perfilInvestimento.liquidez">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" />
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
            <spring:bind path="perfilInvestimento.tipoLiquidez">
        			<select name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" size="1">
    					<c:if test="${availableTempos != null}">
        				<c:forEach var="list" items="${availableTempos}" varStatus="statusTempos">
            			<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == status.value}">selected</c:if>>
                		<c:out value="${list.label}" escapeXml="false" />
            			</option>
        				</c:forEach>
    					</c:if>  
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.risco"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.risco">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" /> % do patrimônio total.
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
        <th>
            <investprofile:label key="perfilInvestimento.riscoMaximo"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.riscoMaximo">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" /> %
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <th>
            <investprofile:label key="perfilInvestimento.segmentoPreferencial"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.segmentoPreferencial">
        			<select name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" size="1">
    					<c:if test="${availableSegmentos != null}">
        				<c:forEach var="list" items="${availableSegmentos}" varStatus="statusSegmentos">
            			<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == status.value}">selected</c:if>>
                		<c:out value="${list.label}" escapeXml="false" />
            			</option>
        				</c:forEach>
    					</c:if>            
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
        <th>
            <investprofile:label key="perfilInvestimento.patrimonio"/>
        </th>
        <td>
            <spring:bind path="perfilInvestimento.patrimonio">
                <input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" 
                    value="<c:out value="${status.value}"/>" /> em R$
                <span class="fieldError"><c:out value="${status.errorMessage}"/></span>
            </spring:bind>
        </td>
    </tr>

    <tr>
        <td></td>
        <td class="buttonBar">            
            <input type="submit" class="button" name="save" 
                onclick="bCancel=false" value="<fmt:message key="button.save"/>" />
            <input type="submit" class="button" name="delete"
                onclick="bCancel=true;return confirmDelete('perfilInvestimento')" 
                value="<fmt:message key="button.delete"/>" />
            <input type="submit" class="button" name="cancel" onclick="bCancel=true"
                value="<fmt:message key="button.cancel"/>" />        
        </td>
    </tr>
</table>
</form>

<script type="text/javascript">
    Form.focusFirstElement(document.forms["perfilInvestimentoForm"]);
</script>

<v:javascript formName="perfilInvestimentoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript"  src="<c:url value="/scripts/validator.jsp"/>"></script>
