<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fs" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <f:form action="/sinh-vien/search" modelAttribute="ch" method="post">
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <f:input type="text" path="ten" cssClass="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
    </f:form>
    <f:form action="/cua-hang/add" modelAttribute="ch" method="post">
        <div class="mb-3">
            <label class="form-label">Mã cửa hàng</label>
            <f:input type="text" class="form-control" path="ma" />
            <f:errors path="ma" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <f:input type="text" class="form-control" path="ten" />
            <f:errors path="ten" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <f:input type="text" class="form-control" path="diaChi" />
            <f:errors path="diaChi" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Thành phố</label>
            <f:input type="text" class="form-control" path="thanhPho" />
            <f:errors path="thanhPho" element="span" cssClass="text-danger" />
        </div>
        <div class="mb-3">
            <label class="form-label">Quốc gia</label>
            <f:input type="text" class="form-control" path="quocGia" />
            <f:errors path="quocGia" element="span" cssClass="text-danger" />
        </div>
        <button type="submit" class="btn btn-primary">ADD</button>
    </f:form>

    <c:if test="${fs:length(listCuaHang) == 0}">
        <h4 class="text-center">Không có dữ liệu</h4>
    </c:if>
    <c:if test="${fs:length(listCuaHang) != 0}">
        <table class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa Chỉ</th>
                <th>Thành Phố</th>
                <th>Quốc Gia</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCuaHang}" var="ch" varStatus="viTri">
                <tr>
                    <td>${viTri.index + 1}</td>
                    <td>${ch.ma}</td>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho}</td>
                    <td>${ch.quocGia}</td>
                    <td>
                        <a href="/cua-hang/detail/${ch.ma}" class="btn btn-primary">Detail</a>
                        <a href="/cua-hang/remove/${ch.ma}" class="btn btn-primary"
                           onclick="return confirm('Bạn có muốn xóa không ?')">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>