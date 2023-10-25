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
        <f:form action="/dich-vu/search" modelAttribute="dv" method="get">
            <div class="mb-3">
                <label class="form-label">Loại dịch vụ</label>
                <f:select path="loaiDichVu" class="form-select">
                    <c:forEach items="${listLoaiDichVu}" var="ldv">
                        <option value="${ldv.id}" ${ldv.id == dv.loaiDichVu.id ? "selected" : ""}>${ldv.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <f:input type="text" path="ten" cssClass="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </f:form>

        <f:form action="/dich-vu/searchDate" modelAttribute="dv" method="get">
            <div class="mb-3">
                <label class="form-label">Ngày Tạo</label>
                <f:input type="date" path="ngayTao" cssClass="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </f:form>

        <f:form action="/dich-vu/add" modelAttribute="dv" method="post">
            <div class="mb-3">
                <label class="form-label">Loại dịch vụ</label>
                <f:select path="loaiDichVu" class="form-select">
                    <c:forEach items="${listLoaiDichVu}" var="ldv">
                        <option value="${ldv.id}" ${ldv.id == dv.loaiDichVu.id ? "selected" : ""}>${ldv.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên dịch vụ</label>
                <f:input type="text" path="ten" cssClass="form-control" />
                <f:errors path="ten" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Đơn giá</label>
                <f:input type="text" path="donGia" cssClass="form-control" />
                <f:errors path="donGia" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày Tạo</label>
                <f:input type="date" path="ngayTao" cssClass="form-control" />
                <f:errors path="ngayTao" cssClass="text-danger" element="span" />
            </div>
            <div>
                <div class="form-check">
                    <f:radiobutton class="form-check-input" path="trangThai" value="0" checked="true" />
                    <label class="form-check-label">Hoạt động</label>
                </div>
                <div class="form-check">
                    <f:radiobutton class="form-check-input" path="trangThai" value="1" />
                    <label class="form-check-label">Ngừng hoạt động</label>
                </div>
            </div>
            <button type="submit" class="btn btn-success">ADD</button>
        </f:form>
        <table class="table">
            <thead>
                <tr>
                    <td>STT</td>
                    <td>Mã</td>
                    <td>Loai dịch vụ</td>
                    <td>Tên dịch vụ</td>
                    <td>Đơn giá</td>
                    <td>Ngày Tạo</td>
                    <td>Trạng thái</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDichVu}" var="dv" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${dv.ma}</td>
                        <td>${dv.loaiDichVu.ten}</td>
                        <td>${dv.ten}</td>
                        <td>${dv.donGia}</td>
                        <td>${dv.ngayTao}</td>
                        <td>${dv.trangThai == 0 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                        <td>
                            <a href="/dich-vu/delete/${dv.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">
                                Remove
                            </a>
                            <a href="/dich-vu/detail/${dv.id}" class="btn btn-primary" onclick="return confirm('Bạn có muốn xem chi tiết không ?')">
                                Detail
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>