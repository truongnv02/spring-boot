<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form action="/sinh-vien/add" method="post">
            <div class="mb-3">
                <label class="form-label">Mã số sinh viên</label>
                <input type="text" class="form-control" name="mssv">
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten">
            </div>
            <div class="mb-3">
                <label class="form-label">Tuổi</label>
                <input type="text" class="form-control" name="tuoi">
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi">
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="true" checked>
                    <label class="form-check-label">Nam</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="false">
                    <label class="form-check-label">Nữ</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">ADD</button>
        </form>

        <table class="table">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>MSSV</th>
                    <th>Tên</th>
                    <th>Tuổi</th>
                    <th>Địa chỉ</th>
                    <th>Giới tính</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listSinhVien}" var="sv" varStatus="viTri">
                    <tr>
                        <td>${viTri.index}</td>
                        <td>${sv.mssv}</td>
                        <td>${sv.ten}</td>
                        <td>${sv.tuoi}</td>
                        <td>${sv.diaChi}</td>
                        <td>${sv.gioiTinh}</td>
                        <td>
                            <a href="/sinh-vien/remove/${sv.mssv}" class="btn btn-primary">Delete</a>
                            <a href="/sinh-vien/detail/${sv.mssv}" class="btn btn-primary">Detail</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>