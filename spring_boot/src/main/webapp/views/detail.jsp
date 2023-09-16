<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/sinh-vien/update/${sv.mssv}" method="post">
        <div class="mb-3">
            <label class="form-label">Mã số sinh viên</label>
            <input type="text" class="form-control" name="mssv" value="${sv.mssv}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${sv.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tuổi</label>
            <input type="text" class="form-control" name="tuoi" value="${sv.tuoi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${sv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="true" ${sv.gioiTinh == "true" ? 'checked' : ''} checked>
                <label class="form-check-label">Nam</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="false" ${sv.gioiTinh == "false" ? 'checked' : ''}>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>