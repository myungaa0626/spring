 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/resources/images/DummysFavicon.png" type="image/x-icon" sizes="16x16">
<style>
	input {
	      display: inline-block;
	      height: 40px;
	      padding: 0 10px;
	      vertical-align: middle;
	      border: 1px solid #dddddd;
	      color: #999999;
	      border-radius: 5px;
      }
	.t2{
		width: 20%;
	}
	.delBtn {
		cursor : pointer;
	}	
.collapsible {
    display: inherit;
  background: none;
  border: none;
  outline: none;
  cursor:pointer;
  margin-bottom:16px;
}
.collapsible:after {
  color: white;
  font-weight: bold;
  float: right;
  margin-left: 5px;
}

.collapsiblecontent {
  padding: 0 18px;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.2s ease-out;
}
</style>
</head>
<body>
	<div id="right-panel" class="right-panel">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<jsp:include page="/WEB-INF/views/include/sidebar.jsp" />
		<div id="main_content" class="content">
			<div class="row">
				<div class="col">
					<div class="row">
						<h1 class="col-12">${gaussian.gaussian_name } 수정</h1>
					</div>
					<br>
					<div class="row">
						<div class="col-12">
							<div class="row">
								<button class="collapsible col-1"><h3 style="margin: 0 auto;"><i class="fa fa-question-circle"></i></h3></button>
								<div class="collapsiblecontent col-11">
									<video src="/resources/video/gaussaian_video.mp4" width="500" height="300" controls></video>
									<p>만일 설정 외의 값도 지정하고 싶다면 "$else"라는 값으로 컬럼명을 지정 정하면 설정외의 모든 값에 적용됩니다.</p>
								</div>
							</div>
							<script>
							var coll = document.getElementsByClassName("collapsible");
							var i;
							
							for (i = 0; i < coll.length; i++) {
							  coll[i].addEventListener("click", function() {
							    this.classList.toggle("active");
							    var content = this.nextElementSibling;
							    if (content.style.maxHeight){
							      content.style.maxHeight = null;
							    } else {
							      content.style.maxHeight = content.scrollHeight + "px";
							    } 
							  });
							}
							</script>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped">
						<thead class="table-light">
							<tr>
								<th class="t2">정규분포이름</th>
								<th colspan="3"><input type="text" id="gaussianName" placeholder="정규분포이름" value="${gaussian.gaussian_name }" ></th>
							</tr>
							<tr>
								<th>컬럼명</th>
								<th colspan="3"><input type="text" id="gaussianColumnName" placeholder="적용시킬컬럼명" value="${gaussian.gaussian_col }"></th>
							</tr>
							<tr>
								<th>데이터</th>
								<th>평균</th>
								<th>표준편차</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody class="gaussianDatas">
							<c:forEach items="${resultList }" var="result">
								<tr>
									<td><input data-type="name" type="text" style="width:100%" placeholder="데이터값" value="${result.gaussian_result }"></td>
									<td><input data-type="average" type="number" style="width:100%" placeholder="평균" value="${result.gaussian_result_avg }"></td>
									<td><input data-type="deviation" type="number" style="width:100%" placeholder="표준편차" value="${result.standard_deviation }"></td>
									<td><div class="icon-container"><span class="ti-close delBtn"></span></div></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td><button class="btn tablebtn btn-outline-secondary" id="rowAddBtn">ROW추가</button></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>

			</div>
		</div>
		
		<section>
			<div class="createnav">
				<div class="btnArea">
					<div class="navbtn btn btn-outline-success" id="saveBtn">저장하기</div>
					<div class="navbtn btn btn-outline-success" id="listBtn">목록으로</div>
					<div class="navbtn btn btn-outline-success" id="homeBtn">홈으로</div>
				</div>
			</div>
		</section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
<script>
	function delBtnAddEvent(){		$('.delBtn').on({			click : deleteRow		})} 
	delBtnAddEvent()

	$('#rowAddBtn').on({
		click : addRow
	})
	$('#listBtn').on({
		click : ()=>{
		 	location.href="/gaussian/gaussianList.do";
		}
	})
	$('#homeBtn').on({
		click: ()=>{
			location.href = "/index.do"
		}
	})
	$('#saveBtn').on({
		click : saveGaussian
	})
	
	
	
	function addRow(){
			let txt = '<tr>' +
								'<td><input data-type="name" type="text" style="width:100%" placeholder="데이터값"></td>' +
								'<td><input data-type="average" type="number" style="width:100%" placeholder="평균"></td>' +
								'<td><input data-type="deviation" type="number" style="width:100%" placeholder="표준편차"></td>' +
								'<td><div class="icon-container"><span class="ti-close delBtn"></span></div></td>'+
							'</tr>';
		$(".gaussianDatas").append(txt);
		delBtnAddEvent();
	}
	
	function deleteRow(event){
		$(event.target).closest('tr').remove();
	}
	function saveGaussian(){
		if(!checkInputBox()){
			Swal.fire({
				title:'내용 모두 채워주세요.',
				  imageUrl: '/resources/images/failMonster.png',
				  imageWidth: 220,
				  imageHeight: 250,
				  imageAlt: 'Custom image',
				  width:400
				})
			return;
		}
		const gaussianNameVal = $('#gaussianName').val();
		const gaussianColumnVal = $('#gaussianColumnName').val();
		const list = $('.gaussianDatas > tr');
		let listdata = [];

		$(list).each((index,data)=>{
			let result = {
					"gaussian_result_no" : "",
					"gaussian_no" : "",
					"gaussian_result" : $(data).find('input[data-type=name]').val(),
					"gaussian_result_avg" : $(data).find('input[data-type=average]').val(),
					"standard_deviation" : $(data).find('input[data-type=deviation]').val()
				}
			listdata.push(result);
		})

		let datas = {
			"gaussian" : {	
				"gaussian_no" : '${gaussian.gaussian_no}',
				"userid" : "",
				"gaussian_col" : gaussianColumnVal,
				"gaussian_name" : gaussianNameVal
			},
			"list" : listdata
		}
		$.ajax({
			"type":"post",
			"url" : "updateGaussian.do",
			"data" : JSON.stringify(datas),
			"contentType":"application/json",
			success : (result)=>{
				if(result.result == 'success'){
					Swal.fire({
						title:'정규분포 저장을 성공했습니다.',
						  imageUrl: '/resources/images/successMonster.png',
						  imageWidth: 220,
						  imageHeight: 250,
						  imageAlt: 'Custom image',
						  width:400
						}).then(()=>{
							location.href = "/gaussian/gaussianList.do";				
						}) 
				} else {
					Swal.fire({
						title:'정규분포 저장을 실패했습니다.',
						  imageUrl: '/resources/images/failMonster.png',
						  imageWidth: 220,
						  imageHeight: 250,
						  imageAlt: 'Custom image',
						  width:400
						})
				}
			},
			error : (error)=>{
				Swal.fire({
					title:'정규분포 저장을 실패했습니다.',
					  imageUrl: '/resources/images/failMonster.png',
					  imageWidth: 220,
					  imageHeight: 250,
					  imageAlt: 'Custom image',
					  width:400
					})
			}
		})//ajax end
	}//saveGaussian() end
	function checkInputBox(){
		let result = true;
		const gN = $('#gaussianName').val();
		const gCN = $('#gaussianColumnName').val();
		if(gN == '' || gCN == '') {
			result = false
		}
		const list = $('.gaussianDatas > tr');
		$(list).each((index,data)=>{
				const name = $(data).find('input[data-type=name]').val().trim()
				const avg = $(data).find('input[data-type=average]').val().trim()
				const deviation = $(data).find('input[data-type=deviation]').val().trim()
				if(name == '' || avg == '' || deviation == '') {
					result = false;
				}
		}) // list.foreach end
		return result;
	}//checkInputBox function end
</script>
</html>