<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <f:form action="/phieu-giam-gia/update/${pgg.maPhieu}" method="post" modelAttribute="pgg">
            <div class="mb-3">
                <label class="form-label">Tên Phiếu</label>
                <f:input path="tenPhieu" cssClass="form-control" />
                <f:errors path="tenPhieu" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Giá trị giảm</label>
                <f:input path="giaTriGiam" cssClass="form-control" />
                <f:errors path="giaTriGiam" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Giá trị giảm tối đa</label>
                <f:input path="giaTriGiamToiDa" cssClass="form-control" />
                <f:errors path="giaTriGiamToiDa" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày bắt đầu</label>
                <f:input path="ngayBatDau" type="date" cssClass="form-control" />
                <f:errors path="ngayBatDau" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày kết thúc</label>
                <f:input path="ngayKetThuc" type="date" cssClass="form-control" />
                <f:errors path="ngayKetThuc" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Khách Hàng</label>
                <f:select class="form-select" path="khachHang">
                    <c:forEach items="${listKhachHang}" var="kh">
                        <option value="${kh.ma}">${kh.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </f:form>
    </div>
</body>
</html>