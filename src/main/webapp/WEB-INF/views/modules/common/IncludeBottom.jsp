<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp;<a href="www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <c:if test="${sessionScope.account != null }">
            <c:if test="${sessionScope.account.authenticated}">
                <c:if test="${sessionScope.account.bannerOption}">
                    ${sessionScope.account.bannerName}
                </c:if>
            </c:if>
        </c:if>
    </div>

</div>

</body>
</html>

</div>
