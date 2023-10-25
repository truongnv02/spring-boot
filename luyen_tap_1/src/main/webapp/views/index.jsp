<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fs" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <f:form action="/phieu-giam-gia/search" modelAttribute="pgg" method="get">
            <div class="mb-3">
                <label class="form-label">FROM</label>
                <f:input type="date" path="ngayBatDau" cssClass="form-control" />
            </div>
            <div class="mb-3">
                <label class="form-label">TO</label>
                <f:input type="date" path="ngayKetThuc" cssClass="form-control" />
            </div>
            <div>
                <label class="form-label">Khách Hàng</label>
                <f:select class="form-select" path="khachHang">
                    <c:forEach items="${listKhachHang}" var="kh">
                        <option value="${kh.ma}" ${kh.ma == pgg.khachHang.ma ? "selected" : ""}>${kh.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </f:form>
        <c:if test="${ fs:length(listPhieuGiamGia.content) == 0 }">
            <h4 class="text-center">Không có dữ liệu</h4>
        </c:if>
        <c:if test="${ fs:length(listPhieuGiamGia.content) != 0 }">
            <table class="table">
                <thead>
                    <tr>
                        <td>#</td>
                        <td>Mã</td>
                        <td>Tên phiếu</td>
                        <td>Ngày bắt đầu</td>
                        <td>Ngày kết thúc</td>
                        <td>Giá trị giảm</td>
                        <td>Trạng thái</td>
                        <td>Tên khách hàng</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listPhieuGiamGia.content}" var="pgg" varStatus="stt">
                        <c:set var="realIndex" value="${(listPhieuGiamGia.number) * listPhieuGiamGia.size + stt.index}" />
                        <tr>
                            <td>${realIndex + 1}</td>
                            <td>${pgg.maPhieu}</td>
                            <td>${pgg.tenPhieu}</td>
                            <td>${pgg.ngayBatDau}</td>
                            <td>${pgg.ngayKetThuc}</td>
                            <td>${pgg.giaTriGiam}</td>
                            <td>${pgg.trangThai == 1 ? "Còn hạn" : "Kết thúc"}</td>
                            <td>${pgg.khachHang.ten}</td>
                            <td>
                                <a href="/phieu-giam-gia/view-update/${pgg.maPhieu}" class="btn btn-success"
                                   onclick="return confirm('Bạn có muốn xem chi tiết không ?')">
                                    Update
                                </a>
                                <a href="/phieu-giam-gia/delete/${pgg.maPhieu}" class="btn btn-danger"
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
                    <c:forEach begin="0" end="${listPhieuGiamGia.totalPages - 1}" varStatus="loop">
                        <li class="page-item">
                            <a class="page-link" href="/phieu-giam-gia/hien-thi?page=${loop.begin + loop.count - 1}">
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