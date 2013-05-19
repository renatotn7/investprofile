<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carteiraRecomendadaList.title"/></title>
<content tag="heading"><fmt:message key="carteiraRecomendadaList.heading"/></content>

<c:set var="buttons">
    <button type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'">
        <fmt:message key="button.done"/>
    </button>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>
  
<form method="post" action="<c:url value="/carteiraRecomendadaList.html"/>" id="carteiraRecomendadaForm">
<table>
<tr>
  <td>
		<select name="idPerfilInvestimento" id="idPerfilInvestimento" size="1">
			<c:if test="${carteiraRecomendadaLista.perfilInvestimentoLista != null}">
				<c:forEach var="list" items="${carteiraRecomendadaLista.perfilInvestimentoLista}"	varStatus="statusPerfilInvestimento">
					<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == carteiraRecomendadaLista.idPerfilInvestimento}">selected</c:if>>
					<c:out value="${list.label}" escapeXml="false"/></option>
				</c:forEach>
			</c:if>
		</select>
	</td>
	<td>
		<select name="idCarteiraRecomendada" id="idCarteiraRecomendada" size="1">
			<c:if test="${carteiraRecomendadaLista.carteiraRecomendadaListaPorData != null}">
				<c:forEach var="list" items="${carteiraRecomendadaLista.carteiraRecomendadaListaPorData}"	varStatus="statusCarteiraRecomendada">
					<option value="<c:out value="${list.value}"/>" <c:if test="${list.value == carteiraRecomendadaLista.idCarteiraRecomendada}">selected</c:if>>
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

<display:table name="carteiraRecomendadaLista.carteiraRecomendadaAcaoLista" cellspacing="0" cellpadding="0" requestURI=""
    id="carteira" pagesize="25" class="list carteiraRecomendadaLista.carteiraRecomendadaAcaoLista" export="true">
    <c:choose>
      <c:when test="${availableOperacoes != null}">
      	<c:forEach items="${availableOperacoes}" var="list" varStatus="statusOperacoes">
      		<c:if test="${list.value == carteira.operacao}">
     				<display:column escapeXml="true" sortable="true"
           		titleKey="operacao"><c:out value="${list.label}" escapeXml="false"/>
           	</display:column>
          </c:if>
      	</c:forEach>
      </c:when>
    	<c:otherwise>
    		<display:column property="operacao" escapeXml="true" sortable="true"
         titleKey="operacao"/>
    	</c:otherwise>
    </c:choose>
		<display:column property="acao.codigoBovespa" escapeXml="true" sortable="true"
         titleKey="acao.codigoBovespa"/>
    <display:column property="acao.nome" escapeXml="true" sortable="true"
         titleKey="acao.nome"/>         
    <display:column property="preco" escapeXml="true" sortable="true"
         titleKey="preco"/>
    <display:column property="grauConfianca" escapeXml="true" sortable="true"
         titleKey="grauConfianca"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
highlightTableRows("carteira");
</script>
