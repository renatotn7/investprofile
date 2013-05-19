<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="carteiraList.title"/></title>
<content tag="heading"><fmt:message key="carteiraList.heading"/></content>

<c:set var="buttons">
    <button type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCarteira.html"/>'">
        <fmt:message key="button.add"/>
    </button>

    <button type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'">
        <fmt:message key="button.done"/>
    </button>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="carteiraList" cellspacing="0" cellpadding="0" requestURI=""
    id="carteiraList" pagesize="25"  class="table carteiraAtualList" export="true">

    <display:column property="id" escapeXml="true" sortable="true"
        url="/editCarteira.html" paramId="id" paramProperty="id"
        titleKey="carteira.id"/>
    <display:column property="income" escapeXml="true" sortable="true"
         titleKey="carteira.income"/>
    <display:column property="carteiraDate" escapeXml="true" sortable="true"
         titleKey="carteira.carteiraDate"/>
    <display:setProperty name="paging.banner.item_name" value="carteira"/>
    <display:setProperty name="paging.banner.items_name" value="carteiras"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
highlightTableRows("carteiraList");
</script>
