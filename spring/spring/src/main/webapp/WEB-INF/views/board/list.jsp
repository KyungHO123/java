<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<h1>게시글 리스트</h1>

<form action="<c:url value="/board/list"/>" method="get">
   <div class="input-group mb-3">
      <select name="type" class="form-control">
         <option value="all" <c:if test="${pm.cri.type == 'all'}">selected</c:if>>전체</option>
         <option value="title" <c:if test="${pm.cri.type == 'title'}">selected</c:if>>제목</option>
         <option value="writer"<c:if test="${pm.cri.type == 'writer'}">selected</c:if>>작성자</option>
      </select>
      <input type="text" name="search" class="form-contorl" placeholder="검색어를 입력하세요" value="${pm.cri.search}">
   </div>
</form>

<table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>게시판</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>추천/비추천</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="board">
      <tr>
        <td>${board.bo_num}</td>
        <td>${board.bo_co_name}</td>
        <td>
           <c:url value="/board/detail" var="url">
             <c:param name="page" value="${pm.cri.page}"/>
             <c:param name="type" value="${pm.cri.type}"/>
             <c:param name="search" value="${pm.cri.search}"/>
             <c:param name="boNum" value="${board.bo_num}"/>
          </c:url>
          <a href="${url}">${board.bo_title}</a>
        </td>
        <td>
           <c:url value="/board/list" var="url">
             <c:param name="type" value="writer"/>
             <c:param name="search" value="${board.bo_me_id}"/>
          </c:url>
           <a href="${url}">${board.bo_me_id}</a>
        </td>
        <td>${board.bo_view}</td>
        <td>${board.bo_up}/${board.bo_down}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>

 <ul class="pagination justify-content-center">
    <c:if test="${pm.prev}">
       <c:url value="/board/list" var="url">
          <c:param name="page" value="${pm.startPage - 1}"/>
          <c:param name="type" value="${pm.cri.type}"/>
          <c:param name="search" value="${pm.cri.search}"/>
       </c:url>
       <li class="page-item">
          <a class="page-link" href="${url}">이전</a>
       </li>
    </c:if>
    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
       <c:url value="/board/list" var="url">
          <c:param name="page" value="${i}"/>
          <c:param name="type" value="${pm.cri.type}"/>
          <c:param name="search" value="${pm.cri.search}"/>
       </c:url>
       <li class="page-item <c:if test="${pm.cri.page == i }"> active</c:if>">
          <a class="page-link" href="${url}">${i}</a>
       </li>
    </c:forEach>
    <c:if test="${pm.next}">
       <c:url value="/board/list" var="url">
          <c:param name="page" value="${pm.endPage + 1}"/>
          <c:param name="type" value="${pm.cri.type}"/>
          <c:param name="search" value="${pm.cri.search}"/>
       </c:url>
       <li class="page-item">
          <a class="page-link" href="${url}">다음</a>
      </li>
    </c:if>
</ul>
<a class="btn btn-outline-success" href="<c:url value="/board/insert"/>">글쓰기</a>