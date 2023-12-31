<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <f:form action="/sinh-vien/update/${sv.mssv}" modelAttribute="sv" method="post">
        <div class="mb-3">
            <label class="form-label">Mã số sinh viên</label>
            <f:input type="text" class="form-control" path="mssv" value="${sv.mssv}" />
            <f:errors path="mssv" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <f:input type="text" class="form-control" path="ten" value="${sv.ten}" />
            <f:errors path="ten" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Tuổi</label>
            <f:input type="text" class="form-control" path="tuoi" value="${sv.tuoi}" />
            <f:errors path="tuoi" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <f:input type="text" class="form-control" path="diaChi" value="${sv.diaChi}" />
            <f:errors path="diaChi" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <f:radiobutton class="form-check-input" path="gioiTinh" value="true" checked="true" />
                <label class="form-check-label">Nam</label>
            </div>
            <div class="form-check">
                <f:radiobutton class="form-check-input" path="gioiTinh" value="false" />
                <label class="form-check-label">Nữ</label>
            </div>
            <f:errors path="gioiTinh" element="span" cssClass="text-danger" />
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </f:form>
</div>
</body>
</html>