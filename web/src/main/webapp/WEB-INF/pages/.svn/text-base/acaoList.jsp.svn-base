<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="acaoList.title"/></title>
<content tag="heading"><fmt:message key="acaoList.heading"/></content>

<c:set var="buttons">
    <button type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/acaoform.html"/>'">
        <fmt:message key="button.add"/>
    </button>

    <button type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'">
        <fmt:message key="button.done"/>
    </button>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="acaoLista" cellspacing="0" cellpadding="0" requestURI=""
    id="acaoLista" class="table acaoList" pagesize="25" export="true">

    <display:column property="id" escapeXml="true" sortable="true"
        url="/acaoform.html" paramId="id" paramProperty="id"
        titleKey="acao.id"/>
    <display:column property="codigoBovespa" escapeXml="true" sortable="true"
         titleKey="acao.codigoBovespa"/>
    <display:column property="codigoADR" escapeXml="true" sortable="true"
         titleKey="acao.codigoADR"/>
    <display:column property="nome" escapeXml="true" sortable="true"
         titleKey="acao.nome"/>
    <display:column property="fatorNegociacao" escapeXml="true" sortable="true"
         titleKey="acao.fatorNegociacao"/>
    <display:column property="segmento" escapeXml="true" sortable="true"
         titleKey="acao.segmento"/>
  
    <display:setProperty name="paging.banner.item_name" value="acao"/>
    <display:setProperty name="paging.banner.items_name" value="acoes"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
highlightTableRows("acaoList");
</script>
