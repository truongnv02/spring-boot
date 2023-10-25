<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fs" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <f:form action="/dong-vat/search" modelAttribute="dv" method="post">
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <f:input type="text" path="ten" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </f:form>
        <f:form action="/dong-vat/add" modelAttribute="dv" method="post">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <f:input path="id" cssClass="form-control"/>
                <f:errors path="id" cssClass="text-danger" element="span" value="${dv.id}" />
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <f:input path="ten" cssClass="form-control" />
                <f:errors path="ten" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Tuổi</label>
                <f:input path="tuoi" cssClass="form-control"/>
                <f:errors path="tuoi" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Khu vực</label>
                <f:input path="khuVuc" cssClass="form-control" />
                <f:errors path="khuVuc" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Cân nặng</label>
                <f:input path="canNang" cssClass="form-control" />
                <f:errors path="canNang" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <f:radiobutton path="gioiTinh" class="form-check-input" value="true" checked="true" />
                    <label class="form-check-label">Đực</label>
                </div>
                <div class="form-check">
                    <f:radiobutton path="gioiTinh" class="form-check-input" value="false" />
                    <label class="form-check-label">Cái</label>
                </div>
                <f:errors path="gioiTinh" cssClass="text-danger" element="span" />
            </div>
            <button type="submit" class="btn btn-primary">ADD</button>
        </f:form>
        <a href="/dong-vat/hien-thi-tat-ca" class="btn btn-primary">Hiển Thị</a>
        <table class="table">
            <thead>
                <tr>
                    <td>STT</td>
                    <td>Tên</td>
                    <td>Tuổi</td>
                    <td>Giới Tính</td>
                    <td>Khu vực</td>
                    <td>Cân nặng</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDongVat}" var="dv" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${dv.ten}</td>
                        <td>${dv.tuoi}</td>
                        <td>${dv.gioiTinh == true ? "Đực" : "Cái"}</td>
                        <td>${dv.khuVuc}</td>
                        <td>${dv.canNang}</td>
                        <td>
                            <a href="/dong-vat/view-update/${dv.id}" class="btn btn-success">Detail</a>
                            <a href="/dong-vat/remove/${dv.id}" class="btn btn-danger"
                             onclick="return confirm('Bạn có muốn xóa không ?')">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>