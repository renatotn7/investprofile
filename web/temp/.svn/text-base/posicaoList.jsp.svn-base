<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carteiraAtualList.title"/></title>
<content tag="heading"><fmt:message key="carteiraAtualList.heading"/></content>

<c:set var="buttons">
    <button type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'">
        <fmt:message key="button.done"/>
    </button>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>
  
<form method="post" action="<c:url value="/carteiraAtualList.html"/>" id="carteiraAtualForm">
<table>
<tr>
	<td>
		<select name="idPerfilInvestimento" id="idPerfilInvestimento" size="1">
			<c:if test="${carteiraAtualLista.perfilInvestimentoLista != null}">
				<c:forEach var="list" items="${carteiraAtualLista.perfilInvestimentoLista}"	varStatus="statusPerfilInvestimento">
					<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == carteiraAtualLista.perfilInvestimentoAtual}">selected</c:if>>
					<c:out value="${list.label}" escapeXml="false"/></option>
				</c:forEach>
			</c:if>
		</select>
	</td>
	<td>
     <input type="submit" class="button" name="profileId" 
        onclick="" value="Selecionar" />
	</td>
</tr>
</table>
</form>

<display:table name="carteiraAtualLista.carteiraLista" cellspacing="0" cellpadding="0" requestURI=""
    id="carteira" pagesize="25" class="list carteiraAtualLista.carteiraLista" export="true">
		<display:column property="acao.codigoBovespa" escapeXml="true" sortable="true"
         titleKey="acao.codigoBovespa"/>
    <display:column property="acao.nome" escapeXml="true" sortable="true"
         titleKey="acao.nome"/>
    <display:column property="quantidade" escapeXml="true" sortable="true"
         titleKey="acaoCarteira.quantidade"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>
  
<script type="text/javascript">
highlightTableRows("carteira");
</script>
