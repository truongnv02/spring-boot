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
        <f:form action="/dong-vat/update/${dv.id}" modelAttribute="dv" method="post">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <f:input path="id" cssClass="form-control" readonly="true" />
                <f:errors path="id" cssClass="text-danger" element="span" />
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
                    <label class="form-check-label">Dực</label>
                </div>
                <div class="form-check">
                    <f:radiobutton path="gioiTinh" class="form-check-input" value="false" />
                    <label class="form-check-label">Cái</label>
                </div>
                <f:errors path="gioiTinh" cssClass="text-danger" element="span" />
            </div>
            <button type="submit" class="btn btn-primary">UPDATE Động Vật</button>
        </f:form>
    </div>
</body>
</html>