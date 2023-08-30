<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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
	      width:100%;
      }
	.t2{
		width: 20%;
	}
	.delBtn {
		cursor : pointer;
	}
	.content{
		position: relative;
	}
	div[data-type=type] input{
		cursor: pointer;
	}
	#typeChooseArea, #gaussianChooseArea, #previewArea {
		position: absolute;
		background-color: rgba(0, 0, 0, 0.5); /* 검정색 배경색에 50% 투명도 적용 */
		width: 100%;
		height: 100%;
		z-index: 1;
		top: 0;
		left: 0;
		min-height: 1000px;
	}
	#typeChooseArea .child, #gaussianChooseArea .child, #previewArea .child {
	    position: absolute;
	    width: 90%;
	    height: 90%;
	    top: 5%;
	    left: 5%;
	  	opacity: 1;
	}
	#previewArea .child {
	   overflow : scroll;
	}
	#previewArea .child::-webkit-scrollbar {
	  display: none;
	}
	.type-content, .gaussian-content, .preview-content{
		height: calc(100% - 40px);
	}
	.type-bottom, .gaussian-bottom, .preview-bottom{
		height: 40px;
	}
	pre{
		margin-bottom:0px !important;
	}
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/include/sidebar.jsp" />

	<div id="right-panel" class="right-panel">
		<section id="header"> <jsp:include page="/WEB-INF/views/include/header.jsp" /> </section>
		<div class="content">
			<!-- 미리보기 DIV -->
			<div id="previewArea">
				<div class="card child">
					<div class="card-header">
                        <strong class="card-title">
	                        <span class="float-left mt-2">
	                        	미리보기
	                        </span>
							<div class="badge float-right mt-1">
								<button type="button" class="btn btn-secondary btn-sm" id="previewCloseBtn">닫기</button>
							</div>
						</strong>
                    </div>
					<div class="card-body">
						<div class="preview-content">
							<div class="card">
								<div class="card-header">
							        <strong class="card-title">
								         <span class="float-left mt-2">
								         	JSON
								         </span>
									</strong>
							                </div>
								<div class="card-body">
<pre>
[
	{ "컬럼1" : "값1-1", "컬럼2" : "값2-1", "컬럼3" : "값3-1"},
	{ "컬럼1" : "값1-2", "컬럼2" : "값2-2", "컬럼3" : "값3-2"},
	{ "컬럼1" : "값1-3", "컬럼2" : "값2-3", "컬럼3" : "값3-3"},
]
</pre>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
							        <strong class="card-title">
								         <span class="float-left mt-2">
								         	CSV
								         </span>
									</strong>
							                </div>
								<div class="card-body">
<pre>
컬럼1, 컬럼2, 컬럼3, 컬럼4, 컬럼5
값1-1, 값2-1, 값3-1, 값4-1, 값5-1
값1-2, 값2-2, 값3-2, 값4-2, 값5-2
값1-3, 값2-3, 값3-3, 값4-3, 값5-3
</pre>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
							        <strong class="card-title">
								         <span class="float-left mt-2">
								         	HTML TABLE
								         </span>
									</strong>
							                </div>
								<div class="card-body">
<pre>
&#60;table&#62;
	&#60;thead&#62;
		&#60;tr&#62;
			&#60;th&#62;컬럼1&#60;/th&#62;
			&#60;th&#62;컬럼2&#60;/th&#62;
		&#60;/tr&#62;
	&#60;/thead&#62;
	&#60;tbody&#62;
		&#60;tr&#62;
			&#60;td&#62;값1-1&#60;/td&#62;
			&#60;td&#62;값2-1&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td&#62;값1-2&#60;/td&#62;
			&#60;td&#62;값2-2&#60;/td&#62;
		&#60;/tr&#62;
	&#60;/tbody&#62;
&#60;/table&#62;
</pre>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
							        <strong class="card-title">
								         <span class="float-left mt-2">
								         	SQL
								         </span>
									</strong>
							                </div>
								<div class="card-body">
<pre>
insert into 스키마이름(컬럼1, 컬럼2, 컬럼3) values(값1-1, 값2-1, 값3-1);
insert into 스키마이름(컬럼1, 컬럼2, 컬럼3) values(값1-2, 값2-2, 값3-2);
insert into 스키마이름(컬럼1, 컬럼2, 컬럼3) values(값1-3, 값2-3, 값3-3);
</pre>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 타입 선택 DIV -->
			<div id="typeChooseArea">
				<div class="card child">
					<div class="card-header">
                        <strong class="card-title">
	                        <span class="float-left mt-2">
	                        	타입을 선택하세요
	                        </span>
							<div class="badge float-right mt-1">
								<button type="button" class="btn btn-outline-primary btn-sm" id="type_all_btn"><i class="fa fa-star"></i>&nbsp; 전체 타입</button>
								<button type="button" class="btn btn-outline-secondary btn-sm"id="type_admin_btn"><i class="fa fa-lightbulb-o"></i>&nbsp; 기본 타입</button>
	                    		<se:authorize access="isAuthenticated()">
									<button type="button" class="btn btn-outline-success btn-sm"id="type_mine_btn"><i class="fa fa-magic"></i>&nbsp; 내 타입</button>
									<button type="button" class="btn btn-outline-warning btn-sm"id="type_gaussian_btn"><i class="fa fa-map-marker"></i>&nbsp; 정규분포</button>
								</se:authorize>
							</div>
						</strong>
                    </div>
					<div class="card-body">
						<div class="type-content">
						</div>
						<div class="type-bottom">
							<div class="badge float-right mt-1">
								<button type="button" class="btn btn-secondary btn-sm" id="typeCloseBtn">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 정규분포 선택 DIV -->
			<div id="gaussianChooseArea">
				<div class="card child">
					<div class="card-header">
                        <strong class="card-title">
	                        <span class="float-left mt-2">
	                        	정규분포를 선택하세요
	                        </span>
						</strong>
                    </div>
					<div class="card-body">
						<div class="gaussian-content">
						</div>
						<div class="gaussian-bottom">
							<div class="badge float-right mt-1">
								<button type="button" class="btn btn-secondary btn-sm" id="gaussianCloseBtn">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="continer">
			<!-- 상단 설명 -->
				<div class="row">
					<div class="col">
						<div class="row">
							<h1 class="col-12">나만의 스키마 생성</h1>
						</div>
						<br>
						<div class="row">
							<div class="col-12">
								<p>컬럼의 이름과 타입, 옵션을 선택하세요!</p>
								<p>미리보기, 생성하기 버튼으로 더미데이터를 생성합니다.</p>
								<div class="row">
								<button class="collapsible col-1"><h3 style="margin: 0 auto;"><i class="fa fa-question-circle"></i></h3></button>
								<div class="collapsiblecontent col-11">
								  <p>나오는 정보는 미리보기를 통해 확인해주시기 바랍니다.</p>
								  <p>컬럼 이름과 타입을 선택해주고, 공백은 얼마나 많은 값을 비울껀지 %로 작성해주시기 바랍니다.</p>
								  <p>가장 우측에 있는 선택옵션에 경우 있을 시 범위를 지정해주시기 바랍니다.</p>
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
				<!-- schema -->
				<div class="row">
					<div class="col-md-12">
						<table class="table table-striped">
							<thead class="table-light">
								<tr>
									<th colspan="2" ><span class="col-md-4">#스키마 이름</span><input type="text" id="schemaName" placeholder="스키마 이름" class="col-md-8"></th>
									<th colspan="2" ><span class="col-md-4">#스키마 비밀번호</span><input type="text" id="schema_password" placeholder="있을 경우 비공개" class="col-md-8"></th>
									<th></th>
								</tr>
								<tr>
									<th colspan="4" ><span class="col-md-4">#스키마 설명</span><input type="text" id="schemaContent" placeholder="스키마 설명" class="col-md-8"></th>
									<th></th>
								</tr>
								<tr>
									<th>이름</th>
									<th>타입</th>
									<th>옵션(공백 %)</th>
									<th colspan="2">선택옵션</th>
								</tr>
							</thead>
							<tbody id="schemaarea">
								<tr class="schema">
									<td class="col-sm-2 col-md-2 col-lg-2"><div data-type="name" ><div class="datasection"><input type="text" value="컬럼 이름"></div></div></td>
									<td class="col-sm-2 col-md-2 col-lg-2"><div data-type="type" data-value="201" ><div class="datasection"><input data-value="201" process-value="2" type="text" value="랜덤 숫자" readonly/></div></div></td>
									<td class="col-sm-3 col-md-3 col-lg-3"><div data-type="options"  ><div class="datasection"><input type="text" value="0"  min="0" max="100"></div></div></td>
									<td class="col-sm-3 col-md-3 col-lg-3">
										<div data-type="selectoptions"  >
											<div class="datasection row">
												<input type="number" value="1" class="col-sm-6 col-md-6 col-lg-6" placeholder="min"  min="-9223372036854775806" max="9223372036854775806">
												<input type="number" value="100" class="col-sm-6 col-md-6 col-lg-6" placeholder="max" min="–9223372036854775806" max="9223372036854775806">
											</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1 col-lg-1"><div data-type="close"  ><div class="datasection"><div class="icon-container"><span class="ti-close delBtn"></span></div></div></div></td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td><button class="btn tablebtn btn-outline-secondary" id="addbtn">ROW추가</button></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="2" ><span class="col-md-4">#데이터 수</span><input type="text" id="rowNum" placeholder="데이터 개수" class="col-md-8" value="100"></td>
									<td colspan="2" ><span class="col-md-4">#데이터 타입</span>
										<div class="col-md-8"  style="display: inline-block;">
											<select name="select" id="printType" class="form-control">
	                                             <option value="1">JSON</option>
	                                             <option value="2">CSV</option>
	                                             <option value="3">HTML</option>
	                                             <option value="4">SQL</option>
	                                             <!-- <option value="5">Excel</option> -->
	                                         </select>
                                         </div>
									</td>
									<td></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div  class="row">
					<div  class="col-12">
						<jsp:include page="/WEB-INF/views/include/footer.jsp" />
					</div>
				</div>
			</div>
		</div>
	<!-- .content -->
	<div class="createnav">
		<div class="btnArea">
			<div class="navbtn btn btn-outline-success" id="previewBtn">미리보기</div>
			<div class="navbtn btn btn-outline-success" id="createBtn">생성하기</div>
	        <se:authorize access="isAuthenticated()">
			<div class="navbtn btn btn-outline-success" id="saveBtn">저장하기</div>
			</se:authorize>
			<div class="navbtn btn btn-outline-success" id="homeBtn">홈</div>
		</div>
	</div>
	</section>
	</div>

</body>
<script>
	// variable setting
	const list = $('#schemaarea');
	/** 현재 선택한 타입 input 태그 */
	let pickedType = null;
	/** 현재 선택한 타입 목록의 종류 전체, 공공, 내 타입*/
	let typeType = "all";
	/** 검색어 */
	let searchKeyword = "";
	/** Drag and Drop 이벤트용 변수 */
	let picked = null; 
	let pickedIndex = null;
	// ===== event/attr setting =====
	$('.schema').attr('draggable','true');
	$('div[data-type="close"] > .datasection').on({
		click : delColumn
	})
	$("#previewBtn").on({
		click: ()=>{
			$('#previewArea').toggle()
		}
	})
	$("#createBtn").on({
		click: downloadFile
	})
	$('#saveBtn').on({
		click: saveSchema
	})
	$('#homeBtn').on({
		click : ()=>{location.href = "/index.do"}
	})
	$("#addbtn").on({
		click : addColumn
	})
	$('#typeCloseBtn').on({
		click : ()=>{$('#typeChooseArea').toggle();}
	})
	$('#typeChooseArea').toggle();
	$('#gaussianChooseArea').toggle();
	$('div[data-type=type] input').on({
		click : typeClickEventFunction
	})
	$('#type_all_btn').on({
		click : ()=>{
			typeType = "all"
			readType();
		}
	})
	$('#type_admin_btn').on({
		click : ()=>{
			typeType = "admin"
			readType();
		}
	})
	$('#type_mine_btn').on({
		click : ()=>{
			typeType = "mine"
			readType();
		}
	})
	$('#type_gaussian_btn').on({
		click : ()=>{
			typeType = "gaussian"
			readType();
		}
	})
	$('#gaussianCloseBtn').on({
		click : ()=>{
			$('#gaussianChooseArea').toggle();
		}
	})
	$('#previewCloseBtn').click(()=>{$('#previewArea').toggle()})
	$('#previewArea').toggle()
	// ===== drag and drop set =====
	list.on({
		'dragstart':(e)=>{
			if($(e.target).attr('data-type') != 'click'){
			}
			const obj = $(e.target).closest('tr');
			pickedIndex = [...obj[0].parentNode.children].indexOf(obj[0]);
			picked = obj[0];
		}, 
		'dragover':(e)=>{
			e.preventDefault()
		},
		'drop':(e)=>{
			const obj = $(e.target).closest('tr');
			const index = [...obj[0].parentNode.children].indexOf(obj[0]);
			index > pickedIndex ? obj[0].after(picked) : obj[0].before(picked)
		}
	});// list on end
	// ===== drag and drop end =====
	// createDummy() function start
	function createDummy(){
		let paramData = {
				"row" : $('#rowNum').val(), // 생성할 데이터의 숫자
				"type" : $('#printType option:selected').val(), // 데이터 생성 타입 (Excel , JSON 등등...)
				"schema_name" : $('#schemaName').val(),
				"schema_no" : 0,
				"schema_content" : $('#schemaContent').val(),
				"schema_password" : $('#schema_password').val(),
				"list" : readColumn()
		}
		$.ajax({
			type:"post",
			url : "createData.do",
			data : JSON.stringify(paramData),
			contentType:'application/json',
			success : (data)=>{

			},
			error : (error)=>{

			}
		}) // ajax end
	}// createDummy function end
	
	// downloadFile() function start
	function downloadFile(){
		let paramData = {
				"row" : $('#rowNum').val(), // 생성할 데이터의 숫자
				"type" : $('#printType option:selected').val(), // 데이터 생성 타입 (Excel , JSON 등등...)
				"schema_name" : $('#schemaName').val(),
				"schema_no" : 0,
				"schema_content" : $('#schemaContent').val(),
				"schema_password" : $('#schema_password').val(),
				"list" : readColumn()
		}
		$.ajax({
			type:"post",
			url : "schemaDownload.do",
			data : JSON.stringify(paramData),
			contentType:'application/json',
			  success: function(data, status, xhr) {
				  var filename;

				  if($('#schemaName').val() == ''){
					  filename = 'Schema.' + $('#printType option:selected').text().toLowerCase();
				  } else {
					  filename = $('#schemaName').val() + '.' + $('#printType option:selected').text().toLowerCase();
				  }
					
				    var blob = new Blob([data], {type: 'text/plain'});
				    if (typeof window.navigator.msSaveBlob !== 'undefined') {
				      window.navigator.msSaveBlob(blob, filename);
				    } else {
				      var URL = window.URL || window.webkitURL;
				      var downloadUrl = URL.createObjectURL(blob);

				      if (filename) {
				        var a = document.createElement("a");
				        if (typeof a.download === 'undefined') {
				          window.location.href = downloadUrl;
				        } else {
				          a.href = downloadUrl;
				          a.download = filename;
				          document.body.appendChild(a);
				          a.click();
				        }
				      } else {
				        window.location.href = downloadUrl;
				      }

				      setTimeout(function() {
				        URL.revokeObjectURL(downloadUrl);
				      }, 100);
				    }
				  },
			error : (error)=>{
				
			}
		}) // ajax end
	}// downloadFile function end
	
	// saveSchema function start
	function saveSchema(){
		let paramData = {
				"row" : $('#rowNum').val(), // 생성할 데이터의 숫자
				"type" : $('#printType option:selected').val(), // 데이터 생성 타입 (Excel , JSON 등등...)
				"schema_name" : $('#schemaName').val(),
				"schema_no" : 0,
				"schema_content" : $('#schemaContent').val(),
				"schema_password" : $('#schema_password').val(),
				"list" : readColumn()
		}
		$.ajax({
			type:"post",
			url : "saveSchema.do",
			data : JSON.stringify(paramData),
			contentType:'application/json',
			success : (data)=>{
				if(data.result == 'success'){
							Swal.fire({
								title:'스키마 저장을 성공했습니다.',
								  imageUrl: '/resources/images/successMonster.png',
								  imageWidth: 220,
								  imageHeight: 250,
								  imageAlt: 'Custom image',
								  width:400
								}).then(()=>{
									location.href="/schema/schemaList.do?type=mine";					
								}) 
				} else {
					Swal.fire({
						title:'스키마 저장을 실패했습니다.',
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
					title:'스키마 저장을 실패했습니다.',
					  imageUrl: '/resources/images/failMonster.png',
					  imageWidth: 220,
					  imageHeight: 250,
					  imageAlt: 'Custom image',
					  width:400
					})
			}
		}) // ajax end
	}// saveDummy function end

	//컬럼 추가 함수
	function addColumn(){
		const td1 = $('<td>').addClass('col-sm-2 col-md-2 col-lg-2')
							.append($('<div>').attr('data-type', 'name')
												.append($('<div>').addClass('datasection')
																.append($('<input>').attr('type', 'text').val('랜덤 숫자'))));

		const td2_input = $('<input>').attr('data-value', '201').attr("process-value",'2')
																					.attr('type', 'text')
																					.val('랜덤 숫자')
																					.prop('readonly', true);
		$(td2_input).on({
			click : typeClickEventFunction
		})
		const td2 = $('<td>').addClass('col-sm-2 col-md-2 col-lg-2')
							.append($('<div>').attr('data-type', 'type').attr('data-value', '201')
												.append($('<div>').addClass('datasection')
																.append(td2_input)));
		const td3 = $('<td>').addClass('col-sm-3 col-md-3 col-lg-3')
							.append($('<div>').attr('data-type', 'options')
												.append($('<div>').addClass('datasection')
																.append($('<input>').attr('type', 'text').attr("min","0").attr("max","100").val('0'))));
		const td4 = $('<td>').addClass('col-sm-3 col-md-3 col-lg-3')
							.append($('<div>').attr('data-type', 'selectoptions')
												.append($('<div>').addClass('datasection row')
																.append($('<input>').addClass('col-sm-6 col-md-6 col-lg-6')
																					.attr('type', 'number')
																					.attr('min','–9223372036854775806')
																					.attr('max','9223372036854775806')
																					.val('1'))
																.append($('<input>').addClass('col-sm-6 col-md-6 col-lg-6')
																					.attr('type', 'number')
																					.attr('min','–9223372036854775806')
																					.attr('max','9223372036854775806')
																					.val('100'))));
		const td5_span = $('<span>').addClass('ti-close delBtn');
		$(td5_span).on({
			click : delColumn
		})
		const td5 = $('<td>').addClass('col-sm-1 col-md-1 col-lg-1')
							.append($('<div>').attr('data-type', 'close')
												.append($('<div>').addClass('datasection')
																.append($('<div>').addClass('icon-container')
																					.append(td5_span))));
		// tr 태그 생성
		const tr = $('<tr>').addClass('schema').attr('draggable', true)
							.append(td1)
							.append(td2)
							.append(td3)
							.append(td4)
							.append(td5);
		$("#schemaarea").append(tr);
	}// adColumn Function end

	// tr 삭제 함수
	function delColumn(event){
		$(event.target).closest('tr').remove();
	}

	// Column 목록 읽어오기 
	function readColumn(){
		const read = $('.schema');
		let colList = [];
		
		$(read).each((index,data)=>{
			//const col_no = $(data).attr('data-index');
			const schema_no = 1;
			const type_no = $(data).find('div[data-type="type"] > .datasection > input').attr('data-value');
			const process_no = $(data).find('div[data-type="type"] > .datasection > input').attr('process-value');
			const col_name = $(data).find('div[data-type="name"] > .datasection > input').val();
			const col_blank = $(data).find('div[data-type="options"] > .datasection > input').val();
			const col_function = '';
			const col_order = index;
			let col_options = [];
			$(data).find('div[data-type="selectoptions"] > .datasection > input').each((index,data)=>{
				col_options.push($(data).val());
			})
			
			const result = {
				"col_no" : 0,
				"schema_no" : schema_no,
				"type_no" : type_no,
				"col_name" : col_name,
				"col_blank" : col_blank,
				"col_function" : col_function,
				"col_order" : col_order,
				"col_options" : col_options,
				"process_no" : process_no
			}
			colList.push(result) //colList.push() end
		})
		return colList;
	}//readColumn function end
	
	function typeClickEventFunction(event){
		pickedType = event.target;
		$('#typeChooseArea').toggle();
		readType();
	}
	
	/** 타입 클릭시 타입 목록 읽어오기 */
	function readType(){
		$(".type-content").empty();
		$.ajax({
			"url" : "getTypeList.do",
			"type" : "get",
			"data" : {
				"type" : typeType,
				"searchKeyword" : ""
			},
			"success" : (data)=>{
				let appendText = '<table id="typeTable" class="table table-hover">'+
										'<thead>'+
										'<tr>'+
											'<th>타입번호</th>'+
											'<th>작성자</th>'+
											'<th>이름</th>'+
											'<th>설명</th>'+
										'</tr>'+
										'</thead>'+
										'<tbody>';
				$(data.list).each((index,type)=>{
					appendText += 
								  '<tr  type-value="' +type.type_no +'" process-no="'+type.process_no+'">'+
									'<td>'+type.type_no+'</td>'+
									'<td>'+type.userid+'</td>'+
									'<td class="type_name">'+type.type_name+'</td>'+
									'<td>'+type.type_reason+'</td>'+
								  '</tr>';
				})
                appendText += '</tbody>'+
									'</table>';
									
				$('.type-content').append(appendText);
				
				$('#typeTable > tbody > tr').on({
					click : (event)=>{
						let value = $(event.target).closest('tr').attr('type-value');
						let name = $(event.target).closest('tr').find('.type_name').text();
						let process_no = $(event.target).closest('tr').attr('process-no');
						
						$(pickedType).attr("data-value",value);
						$(pickedType).attr("process-value",process_no);
						$(pickedType).val(name);
						
						let col_target = {
							selectoption : $(pickedType).closest('tr').find('div[data-type=selectoptions] > .datasection').closest('td'),
							option : $(pickedType).closest('tr').find('div[data-type=options] > .datasection').closest('td') ,
							close : $(pickedType).closest('tr').find('div[data-type=close] > .datasection').closest('td'),
							datasection : $(pickedType).closest('tr').find('div[data-type=selectoptions] > .datasection')
						}
						
						$(col_target.selectoption).find('.datasection').empty();
						
						if(process_no == 0 || process_no == 1){
							col_target.close[0].after(col_target.selectoption[0]);
						} else if (process_no == 2){
							const txt = '<input type="number" value="1" class="col-sm-6 col-md-6 col-lg-6" placeholder="min"><input type="number" value="100" class="col-sm-6 col-md-6 col-lg-6" placeholder="max">';
							$(col_target.datasection).append(txt);
							col_target.option[0].after(col_target.selectoption[0]);
						} else if (process_no == 3){
							const $span = $('<span class="col-5 gaussianReasonText">#정규분포번호</span>').css("padding-top","7px");
							const $element = $('<input type="text" class="col-7" placeholder="정규분포를 선택해주세요" readonly>');
							$($element).css('cursor','pointer');
							$($element).on({
								click : selectGaussian
							})
							$(col_target.datasection).append($span);
							$(col_target.datasection).append($element);
							col_target.option[0].after(col_target.selectoption[0]);
						}
						$('#typeChooseArea').toggle();
					}
				}) // click event end
				$('#typeTable').DataTable({
		 	 		"pageLength": 10,
		 	 		"lengthChange": false
		 	 	});
			}, //success end
			"error" : (error)=>{
			}
		})
	}//readType function end

	function selectGaussian(event){
		pickedType = event.target;
		$('.gaussian-content').empty();

		$.ajax({
			"url" : "getGaussianList.do",
			"type" : "get",
			"success" : (data)=>{
				let appendText = '<table id="gaussianTable" class="table table-hover">'+
										'<thead>'+
										'<tr>'+
											'<th>정규분포번호</th>'+
											'<th>이름</th>'+
											'<th>컬럼명</th>'+
										'</tr>'+
										'</thead>'+
										'<tbody>';
				$(data.gaussianList).each((index,gaussian)=>{
					appendText += 
								  '<tr gaussian-value="' +gaussian.gaussian_no +'">'+
									'<td>'+gaussian.gaussian_no+'</td>'+
									'<td class="gaussian_name">'+gaussian.gaussian_name+'</td>'+
									'<td>'+gaussian.gaussian_col+'</td>'+
								  '</tr>';
				})
                appendText += '</tbody>'+
									'</table>';
				$('.gaussian-content').append(appendText);
				// 이벤트 추가하는 곳
				$('#gaussianTable > tbody >tr').on({
					click : (event)=>{
						let gaussian_no = $(event.target).closest('tr').attr("gaussian-value");
						let gaussian_name = $(event.target).closest('tr').find('.gaussian_name').text();

						$(pickedType).val(gaussian_no);
						// $(pickedType).siblings('span').text(gaussian_name);
						$('#gaussianChooseArea').toggle();
					}
				})
				// 데이터테이블로 만드는 곳
				$(gaussianTable).DataTable({
		 	 		"pageLength": 10,
		 	 		"lengthChange": false
		 	 	});
				// 보여주기
				$('#gaussianChooseArea').toggle();
			},
			"error" : (error)=>{
			}
		})
	}
	</script>
    <script>
    let refreshFlag = false;
    $(window).on({
    	'beforeunload': ()=> {
    		  if (!refreshFlag) {
    			    // 로컬스토리지에서 'formData' 아이템 삭제
    			    localStorage.removeItem('colData');
    			  }
      	},
      	'load' : ()=> {
      	  // 로컬스토리지에서 'formData' 아이템 가져오기
      	  const formData = localStorage.getItem('colData');
      	  // formData가 존재한다면, 필요한 작업 수행
      	  if (formData) {
      		const col = JSON.parse(formData);

      		const type_no_list = col.type_no_list;
      		const type_name_list = col.type_name_list;
      		const process_no_list = col.process_no_list;
      		const typeFormat = col.typeFormat;
      		
      		const options = $('#printType option');
      		$(options[typeFormat]).attr('selected',true);
      		
      		$('#schemaarea').empty();
			$(type_no_list).each((index, data) => {
				let $tr = $('<tr>', {class: 'schema',draggable: true});

				let $nameTd = $('<td>', {class: 'col-sm-2 col-md-2 col-lg-2'}).appendTo($tr);

				let $nameDiv = $('<div>', {'data-type': 'name'}).appendTo($nameTd);

				let $nameSection = $('<div>', {class: 'datasection'}).appendTo($nameDiv);

				$('<input>', {type: 'text',value: type_name_list[index]}).appendTo($nameSection);

				let $typeTd = $('<td>', {class: 'col-sm-2 col-md-2 col-lg-2'}).appendTo($tr);

				let $typeDiv = $('<div>', {'data-type': 'type','data-value': type_no_list[index]}).appendTo($typeTd);

				let $typeSection = $('<div>', {class: 'datasection'}).appendTo($typeDiv);

				let $typeinput = $('<input>', {'data-value': type_no_list[index],'process-value': process_no_list[index],type: 'text',value: type_name_list[index],readonly: true}).appendTo($typeSection);
				$($typeinput).on({click : typeClickEventFunction})

				let $optionTd = $('<td>', {class: 'col-sm-3 col-md-3 col-lg-3'}).appendTo($tr);

				let $optionDiv = $('<div>', {'data-type': 'options'}).appendTo($optionTd);

				let $optionSection = $('<div>', {class: 'datasection'}).appendTo($optionDiv);

				$('<input>', {type: 'text',value: 0,min: 0,max: 100}).appendTo($optionSection);

				let $closeTd = $('<td>', {class: 'col-sm-1 col-md-1 col-lg-1'}).appendTo($tr);

				let $closeDiv = $('<div>', {'data-type': 'close'}).appendTo($closeTd);

				let $closeSection = $('<div>', {class: 'datasection'}).appendTo($closeDiv);

				let $iconContainer = $('<div>', {class: 'icon-container'}).appendTo($closeSection);

				let $closeBtn = $('<span>', {class: 'ti-close delBtn'}).appendTo($iconContainer);
				$($closeBtn).on({click : delColumn})

				let $selectTd = $('<td>', {class: 'col-sm-3 col-md-3 col-lg-3'}).appendTo($tr);

				let $selectDiv = $('<div>', {'data-type': 'selectoptions'}).appendTo($selectTd);

				let $selectSection = $('<div>', {class: 'datasection row'}).appendTo($selectDiv);

				$('#schemaarea').append($tr);
				}); //each end
				
      	  } // if(formData) end
      	},
      	'keydown': function(e) {
      	  if (e.which === 116) { // 새로고침 이벤트를 감지하기 위한 키 코드
      	    refreshFlag = true;
      	  }
      	},
      	'keyup': function(e) {
      	  if (e.which === 116) {
      	    refreshFlag = false;
      	  }
      	}
    });
    </script>
</html>