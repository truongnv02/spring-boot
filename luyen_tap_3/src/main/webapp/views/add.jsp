<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fs" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h4 class="text-center">ADD Danh Sach Yeu Thich</h4>
    <f:form action="add" modelAttribute="dsyt" method="post">
        <div class="mb-3">
            <label class="form-label">Ghi chú</label>
            <f:input path="ghiChu" cssClass="form-control" />
            <f:errors path="ghiChu" cssClass="text-danger" element="span" />
        </div>
        <div class="mb-3">
            <label class="form-label">Mã khách hàng</label>
            <f:select class="form-select" path="khachHang">
                <c:forEach items="${listKhachHang}" var="kh">
                    <option value="${kh.ma}">${kh.ma}</option>
                </c:forEach>
            </f:select>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <f:radiobutton class="form-check-input" path="trangThai" checked="true" />
                <label class="form-check-label">Hoạt động</label>
            </div>
            <div class="form-check">
                <f:radiobutton class="form-check-input" path="trangThai" />
                <label class="form-check-label">Ngừng hoạt động</label>
            </div>
        </div>
        <button type="submit" class="btn btn-success">ADD</button>
    </f:form>
</div>
</body>
</html>