<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../includes/header.jsp" />
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board View</h6>
		</div>
		<div class="card-body">
			<form method="get"  class="needs-validation" novalidate>
				<div class="form-group">
					<label for="bno" class="font-weight-bold text-warning">bno</label> 
					<input type="text" class="form-control" id="bno"  name="bno" required value=" ${board.bno}" readonly>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="form-group">
					<label for="title" class="font-weight-bold text-warning">title</label> 
					<input type="text" class="form-control" id="title" placeholder="게시글 제목을 입력하세요" name="title" required value=" ${board.title}" readonly>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="form-group">
					<label for="content" class="font-weight-bold text-warning">content</label> 
					<textarea  class="form-control" rows="10"  id="content" placeholder="글 내용 입력하세요" name="content" required readonly>${board.content}
					</textarea>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="form-group">
					<label for="writer" class="font-weight-bold text-warning">writer</label> 
					<input type="text" class="form-control" id="writer" placeholder="이름을 입력하세요" name="writer" required value=" ${board.writer}" readonly>
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<a href="list${cri.listLink}" data-oper="list"  class="btn btn-outline-info float-right m-x1">List</a>
				<a href= "modify${cri.listLink}&bno=${board.bno}" data-oper="modify"  class="btn btn-outline-warning float-right " >Modify</a>
			</form>
		</div>
	</div>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-comments  fa-fw"></i> Reply</h6>
			<button id="addReplyBtn" class="btn btn-primary float-right">New Reply</button>
		</div>
		<div class="card-body">
			<ul class="list-group chat">
				<!-- <li class="list-group-item"> 이부분이 스크립트 리스트화됨
					<div class="header">
						<strong>user00</strong>
						<small class="float-right">2021-04- 12:37</small>
					</div>
					<p class="mt-2">bood <br> djdkdjkk <br>  dndhjdj<br></p>
				</li>	 -->		
			</ul>
		</div>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel">REPLY MODAL</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
            <form method="get"  class="needs-validation" novalidate>
				<div class="form-group">
					<label for="reply" class="font-weight-bold text-warning">reply</label> 
					<input type="text" class="form-control" id="reply" name="reply" required placeholder="mkmk">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="form-group">
					<label for="replyer" class="font-weight-bold text-warning">replyer</label> 
					<input type="text" class="form-control" id="replyer"  name="replyer" required placeholder="mkmkm">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="form-group">
					<label for="replyDate" class="font-weight-bold text-warning">replyDate</label> 
					<input type="text" class="form-control" id="replyDate"  name="replyDate" required placeholder="2929-39-10">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field.</div>
				</div>
			</form>
			</div>
            <div class="modal-footer">
                <button id="modalModBtn" class="btn btn-warning btn-sm ac" type="button" data-dismiss="modal">Modify</button>
                <button id="modalRemoveBtn" class="btn btn-danger btn-sm ac" type="button" data-dismiss="modal">Remove</button>
                <button id="modalRegBtn" class="btn btn-primary btn-sm ac" type="button" data-dismiss="modal">Register</button>
                <button id="modalCloseBtn" class="btn btn-secondary btn-sm " type="button" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
	// Disable form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Get the forms we want to add validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
<script src="/resources/js/reply.js"></script>
<script >
	var bno = <c:out value="${board.bno}"/>;
	var replyUL = $(".chat");
	
	showList(1);
	
	function showList(page) {
		replyService.getList({bno:bno, page : 1}, function(list) {
			console.log(list);
			var str ="";
			replyUL.html("");//원래있던 기존값을 뒤짚어 쓰겠다. str에다가 
			for(var i in list){
				str +=	'<li class="list-group-item data-rno"' + list[i].rno + '">';
				str +=	'	<div class="header">';	
				str +=	'		<strong>' + list[i].replyer + '</strong>';		
				str +=	'	<small class="float-right">'+ replyService.displayTime(list[i].replyDate) + '</small>';
				str +=	'	</div>'	;
				str +=	'	<p class="mt-2">'+list[i].reply+'</p>';
				str +=	'</li>';
			}
			replyUL.html(str);
		})
	}
	$(function() {
		$("#addReplyBtn").click(function() {
			$("#myModal").find("input").val(""); //초기화하고
			$("#replyDate").closest("div").hide(); //replyDate의 div를 숨겨주고
			$(".ac").hide().eq(2).show(); //버튼 0~2 2번째꺼 보여주겠다.
			$("#myModal").modal("show"); 
		})
		
		$("#modalRegBtn").click(function() { //그리고 보여준 버튼을 누르면
			var reply = {bno:bno, reply : $("#reply").val(), replyer : $("#replyer").val()}; //버튼의 인풋박스로다가 val받아온다
			replyService.add(reply, function() { // service에 add에 값을 넣어준다.
				alert(reply);
				$("#myModal").modal("hide");
				
				showList();
			})
		});
	})
	
//	alert(bno);
	//replyService1.add();
	/*
	replyService.getList({bno:bno, page : 1}, function(list) {
		console.log(list);
		for(var i in list){
			console.log(list[i].rno)
		}
	});
	
	replyService.add({bno:bno , reply:"Js에서 쓴글", replyer:"써진작성자"}, function(result){
		alert(result);
	}); 
	replyService.remove(121,function(result){
		alert(result);
	}, function(err) {
		alert("삭제 실패");
	});
	*/
	/* replyService.update({rno:122,reply:"ajax로 수정한 댓글"}, function (result) {
		alert(result);		
	});
	
	replyService.get(122, function(result) {
		console.log(result);
	}); */
</script>

<!-- /.container-fluid -->

<!-- End of Main Content -->
<jsp:include page="../includes/footer.jsp" />