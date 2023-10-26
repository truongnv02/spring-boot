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
        <f:form action="/khach-hang/search" modelAttribute="kh" method="get">
            <div class="mb-3">
                <label class="form-label">Search</label>
                <f:input path="tenKhachHang" cssClass="form-control" />
            </div>
            <div class="mb-3">
                <f:select class="form-select" path="hangKhachHang">
                    <c:forEach items="${listHangKhachHang}" var="hkh">
                        <option value="${hkh.maHang}" ${hkh.maHang == kh.hangKhachHang.maHang ? "selected" : ""}>${hkh.tenHang}</option>
                    </c:forEach>
                </f:select>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </f:form>
        <f:form action="/khach-hang/add" modelAttribute="kh" method="post">
            <div class="mb-3">
                <label class="form-label">Tên Khách Hàng</label>
                <f:input path="tenKhachHang" cssClass="form-control" />
                <f:errors path="tenKhachHang" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <f:input path="sdt" cssClass="form-control" />
                <f:errors path="sdt" cssClass="text-danger" element="span" />
            </div>
            <div class="mb-3">
                <label class="form-label">Giới Tính</label>
                <div class="form-check">
                    <f:radiobutton path="gioiTinh" class="form-check-input" value="1" checked="true" />
                    <label class="form-check-label">Nam</label>
                </div>
                <div class="form-check">
                    <f:radiobutton path="gioiTinh" class="form-check-input" value="0"/>
                    <label class="form-check-label">Nữ</label>
                </div>
            </div>
            <div class="mb-3">
                <f:select class="form-select" path="hangKhachHang">
                    <c:forEach items="${listHangKhachHang}" var="hkh">
                        <option value="${hkh.maHang}">${hkh.tenHang}</option>
                    </c:forEach>
                </f:select>
            </div>
            <button type="submit" class="btn btn-success">ADD</button>
        </f:form>
        <c:if test="${fs:length(listKhachHang.content) == 0}">
            <h4 class="text-center">Không có dữ liệu</h4>
        </c:if>
        <c:if test="${fs:length(listKhachHang.content) != 0}">
        <table class="table">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Tên khách hàng</td>
                    <td>Số điện thoại</td>
                    <td>Giới tính</td>
                    <td>Tên hạng</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listKhachHang.content}" var="kh" varStatus="stt">
                    <c:set var="readIndex" value="${(listKhachHang.number) * listKhachHang.size + stt.index}" />
                    <tr>
                        <td>${readIndex + 1}</td>
                        <td>${kh.tenKhachHang}</td>
                        <td>${kh.sdt}</td>
                        <td>${kh.gioiTinh == 1 ? "Nam" : "Nữ"}</td>
                        <td>${kh.hangKhachHang.tenHang}</td>
                        <td>
                            <a href="/khach-hang/delete/${kh.maKhachHang}" class="btn btn-danger"
                                onclick="return confirm('Bạn có muốn xóa không ?')">
                                Remove
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${listKhachHang.totalPages - 1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/khach-hang/hien-thi?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
        </c:if>
    </div>
</body>
</html>