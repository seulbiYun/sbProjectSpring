<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<style>
	fieldset{
		padding : 20px;
		border: 1px solid #ABD0CE;
		color: #7C7877;
		width: 100%;
		margin: 50px auto; 
	}
	fieldset p{
		margin: 20px 0;
	}
	fieldset > p:last-child{
		margin-left: 150px;
	}
	fieldset p:last-child input{
		padding: 5px 10px;
		background-color: #ABD0CE;
		border:none;
		cursor: pointer;
		color:#7C7877;
	} 
	fieldset p label{
		width: 150px;
		display: inline-block;
		float: left;
	}
	.err{
		display: none;
		color:red;
		font-size: 12px;
	}
</style>
	<form action = "sbPUpdate" method = "post">
		<fieldset>
			<legend>프로젝트 수정</legend>
			<input type = "hidden" id = "sbNo" value = "${sb.sbNo }" name ="sbNo">
			<p>
				<label>프로젝트 이름</label>
				<input type = "text" name = "sbName" value = "${sb.sbName }">
				<span class = "err">프로젝트 이름을 입력해주세요.</span>
			</p>
			<p>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="60" name = "sbContent">${sb.sbContent }</textarea>
				<span class = "err">프로젝트 내용을 입력해주세요.</span>
			</p>
			<p>
				<label>시작 날짜</label>
				<input type = "date" name = "sbStart" value = "${sb.sbStart }">
				<span class = 'err'>프로젝트 시작 날짜를 선택해 주세요.</span>
			</p>
			<p>
				<label>종료 날짜</label>
				<input type = "date" name = "sbEnd" value = "${sb.sbEnd }">
				<span class = 'err'>프로젝트 종료 날짜를 선택해 주세요.</span>
			</p>
			<p>
				<label>진행 상태</label>
				<select name = "sbState">
					<c:if test = "${sb.sbState == 1 }">
						<option value="1" selected="selected">준비</option>
						<option value="2">진행중</option>
						<option value="3">종료</option>
						<option value="4">보류</option>
					</c:if>
					<c:if test = "${sb.sbState == 2 }">
						<option value="1">준비</option>
						<option value="2" selected="selected">진행중</option>
						<option value="3">종료</option>
						<option value="4">보류</option>
					</c:if>
					<c:if test = "${sb.sbState == 3 }">
						<option value="1">준비</option>
						<option value="2">진행중</option>
						<option value="3" selected="selected">종료</option>
						<option value="4">보류</option>
					</c:if>
					<c:if test = "${sb.sbState == 4 }">
						<option value="1">준비</option>
						<option value="2">진행중</option>
						<option value="3">종료</option>
						<option value="4" selected="selected">보류</option>
					</c:if>
				</select>
			</p>
			<p>
				<input type = "submit" value = "수정">
				<input type = "button" id = "back" value = "취소">
			</p>
		</fieldset>
	</form>
	<script>
		var sbNo = $("#sbNo").val();
		$("#back").click(function(){
			location.href = "sbPView?sbNo="+sbNo;
		})
		
		$("form").submit(function(){
			var name = $("input[name='sbName']").val();
			var content = $("textarea[name='sbContent']").val();
			var start = $("input[name='sbStart']").val();
			var end = $("input[name='sbEnd']").val();
			var state = $("select[name='sbState']").val();
			$(".err").css("display","none");
			if(name == ""){
				$(".err").eq(0).css("display","inline");
				return false;
			}
			if(content == ""){
				$(".err").eq(1).css("display","inline");
				return false;
			}
			if(start == ""){
				$(".err").eq(2).css("display","inline");
				return false;
			}
			if(end == ""){
				$(".err").eq(3).css("display","inline");
				return false;
			}
			var startArr = start.split("-");
			var endArr = end.split("-");
			
			var startDate = new Date(startArr[0],startArr[1],startArr[2]);
			var endDate = new Date(endArr[0],endArr[1],endArr[2]);
			
			if(startDate.getTime() > endDate.getTime()){
				alert("종료날짜를 시작날짜보다 뒤로 선택하세요");
				return false;
			}
			if(confirm("수정하시겠습니까??")==true){
				location.href = "sbPUpdate?sbNo="+sbNo;
			}else{
				return false;
			}
		})
	</script>
<%@ include file = "../include/footer.jsp" %>