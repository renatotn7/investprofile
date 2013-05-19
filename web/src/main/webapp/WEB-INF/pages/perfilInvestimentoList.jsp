<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="perfilInvestimentoList.title"/></title>
<content tag="heading"><fmt:message key="perfilInvestimentoList.heading"/></content>

<c:set var="buttons">
    <button type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/perfilinvestimentoform.html"/>'">
        <fmt:message key="button.add"/>
    </button>

    <button type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'">
        <fmt:message key="button.done"/>
    </button>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<c:if test="${perfilInvestimentoLista != null}">
<display:table name="perfilInvestimentoLista" cellspacing="0" cellpadding="0" requestURI=""
    id="perfilInvestimentoLista" pagesize="25" class="table perfilInvestimentoList" export="true">

    <display:column property="nome" escapeXml="true" sortable="true"
    	url="/perfilinvestimentoform.html" paramId="id" paramProperty="id" titleKey="perfilInvestimento.nome"/>
    <c:choose>
    <c:when test="${availableObjetivos != null}">
    	<c:forEach items="${availableObjetivos}" var="list" varStatus="statusObjetivos">
    		<c:if test="${list.value == perfilInvestimentoLista.objetivo}">
   				<display:column escapeXml="true" sortable="true"
         		titleKey="perfilInvestimento.objetivo"><c:out value="${list.label}" escapeXml="false"/>
         	</display:column>
        </c:if>
    	</c:forEach>
    </c:when>
    	<c:otherwise>
   		 	<display:column property="objetivo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.objetivo"/>
    	</c:otherwise>
    </c:choose>
    <display:column property="patrimonio" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.patrimonio"/>
    <display:column property="rendimentoEsperado" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.rendimentoEsperado"/>
    <display:column property="risco" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.risco"/>
    <display:column property="riscoMaximo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.riscoMaximo"/>
    <c:choose>
    <c:when test="${availableSegmentos != null}">
    	<c:forEach items="${availableSegmentos}" var="list" varStatus="statusSegmentos">
    		<c:if test="${list.value == perfilInvestimentoLista.segmentoPreferencial}">
   				<display:column escapeXml="true" sortable="true"
         		titleKey="perfilInvestimento.segmentoPreferencial"><c:out value="${list.label}" escapeXml="false"/>
         	</display:column>
        </c:if>
    	</c:forEach>
    </c:when>
    	<c:otherwise>
    		<display:column property="segmentoPreferencial" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.segmentoPreferencial"/>
    	</c:otherwise>
    </c:choose>         
    <display:column property="liquidez" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.liquidez"/>
    <c:choose>
    <c:when test="${availableTempos != null}">
    	<c:forEach items="${availableTempos}" var="list" varStatus="statusTempos">
    		<c:if test="${list.value == perfilInvestimentoLista.tipoLiquidez}">
   				<display:column escapeXml="true" sortable="true"
         		titleKey="perfilInvestimento.tipoLiquidez"><c:out value="${list.label}" escapeXml="false"/>
         	</display:column>
        </c:if>
    	</c:forEach>
    </c:when>
    	<c:otherwise>
    		<display:column property="tipoLiquidez" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.tipoLiquidez"/>
    	</c:otherwise>
    </c:choose> 
    <display:column property="prazo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.prazo"/>
    <c:choose>
    <c:when test="${availableTempos != null}">
    	<c:forEach items="${availableTempos}" var="list" varStatus="statusTempos">
    		<c:if test="${list.value == perfilInvestimentoLista.tipoPrazo}">
   				<display:column escapeXml="true" sortable="true"
         		titleKey="perfilInvestimento.tipoPrazo"><c:out value="${list.label}" escapeXml="false"/>
         	</display:column>
        </c:if>
    	</c:forEach>
    </c:when>
    	<c:otherwise>
    		<display:column property="tipoPrazo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.tipoPrazo"/>
    	</c:otherwise>
    </c:choose>          
    <display:column property="tempo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.tempo"/>
    <c:choose>
    <c:when test="${availableTempos != null}">
    	<c:forEach items="${availableTempos}" var="list" varStatus="statusTempos">
    		<c:if test="${list.value == perfilInvestimentoLista.tipoTempo}">
   				<display:column escapeXml="true" sortable="true"
         		titleKey="perfilInvestimento.tipoTempo"><c:out value="${list.label}" escapeXml="false"/>
         	</display:column>
        </c:if>
    	</c:forEach>
    </c:when>
    	<c:otherwise>
    		<display:column property="tipoTempo" escapeXml="true" sortable="true"
         titleKey="perfilInvestimento.tipoTempo"/>
    	</c:otherwise>
    </c:choose> 
    <display:setProperty name="paging.banner.item_name" value="perfilInvestimento"/>
    <display:setProperty name="paging.banner.items_name" value="perfisInvestimentos"/>
</display:table>
</c:if>
<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
highlightTableRows("investProfileList");
</script>
