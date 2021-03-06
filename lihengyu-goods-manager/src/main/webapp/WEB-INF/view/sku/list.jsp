<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<div class="container-fluid">
	<button type="button" class="btn btn-success" onclick="add()">添加</button> 
	  <table class="table">
	  	<tr>	

	  	
	  		<th>id</th>
	  		<th>标题</th>
	  		<th>价格</th>
	  		<th>库存</th>
	  		<th>发布时间</th>
	  		<th>成本价</th>
	  		<th>商品名称</th>
	  		<th>品牌</th>
	  		<th>分类</th>
	  		<th>操作</th>
	  	</tr>
	  	<c:forEach items="${pageInfo.list}" var="sku">
	  		<tr>
	  			<td>${sku.id}</td>
	  			<td>${sku.title}</td>
	  			<td>${sku.price}</td>
	  			<td>${sku.stockCount}</td>
	  			<td>
	  				<fmt:formatDate  value="${sku.createTime}" pattern="yyyy-MM-dd"/> 
	  			
	  			</td>
	  			
	  			<td>${sku.spu.brand.name}</td>
	  			<td>${sku.spu.category.name}</td>
	  			<td>
		  			<button type="button" class="btn btn-success" onclick="goDetail(${sku.id})">详情</button>
					<button type="button" class="btn btn-danger">删除</button>
					<button type="button" class="btn btn-warning">修改</button>
	  			</td>
	  		</tr>
	  	</c:forEach>
	  <tr>
		<td colspan="3">
			<jsp:include page="../common/page.jsp"></jsp:include>
		</td>
	</tr>
	  </table>
</div>
<script>
	function add(){
		$("#main").load("/goods/toaddSku")
	}
	
	function goDetail(id){
		$("#main").load("/goods/skuDetail?id="+id)
	}
	function goPage(pagenum){
		
		var url="/goods/skulist?name="+$("#queryName").val()+'&page='+pagenum;
		$("#main").load(url);
	}
</script>