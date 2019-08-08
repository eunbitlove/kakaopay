<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Shortening URL</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	/*
	$(document).ready(function(){		
		getUrlList();
	});
	*/
	
	function fnEnter()
	{
		if (window.event.keyCode != 13) return;
		
		fnBtnClick("s_url");
	}

	function fnBtnClick(colname){


		
		
		/*
		$.ajax({			
			type:"GET",
		    url:"/getUrlList",
	        dataType:"JSON",
	        success : function(obj) {
				getUrlListCallback(obj);				
	        },	       
	        error : function(xhr, status, error) {}
	     });
		*/
		
	
		$("#s_col").val(colname);
		
		
		$.ajax({	
			
		    url		: "/getUrlList",
		    data    : $("#urlForm").serialize(),
	        dataType: "JSON",
	        cache   : false,
			async   : true,
			type	: "POST",	
	        success : function(obj) {
	        	getUrlListCallback(obj);				
	        },	       
	        error 	: function(xhr, status, error) {}
	        
	     });

	}
	
	/* URL 조회 후 콜백 */
	function getUrlListCallback(obj){
		
		var list = obj;
		var listLen = obj.length;
		
		console.log(list);
		console.log(listLen);
		
		var str = "";
		
		if(listLen >  0){
			
			for(var a=0; a<listLen; a++){
				
				var u_no		= list[a].u_no; 
				var s_url 		= list[a].s_url; 
				var f_url 		= list[a].f_url; 
				
				//단축 URL로 검색했을때만 바로 redirect
				if($("#s_col").val() == "s_url")
				{
					window.location.href = f_url;
				} else {
					//이외의 경우는 바로 단축 url을 주소칸에 셋팅
					$("#f_url").val(s_url);
				}
			} 
			
		} else {
			
			//조회 대상 컬럼이 변환 url 인 경우에만 원래 url을 검색한다.
			if($("#s_col").val() == "s_url")
			{			
				this.fnBtnClick("f_url");
			} else {
				
				//s_url, f_url 모두 없으면 DB에 insert 한다.
				
				$.ajax({	
					
				    url		: "/insertUrlList",
				    data    : $("#urlForm").serialize(),
			        dataType: "JSON",
			        cache   : false,
			        async   : true,
					type	: "POST",	
			        success : function(obj) {
			        	insertUrlCallback(obj);				
			        },	       
			        error 	: function(xhr, status, error) {}
			        
			    });
				

			}
		}
	}
	
	//URL DB insert 후 콜백
	function insertUrlCallback(obj){
		
		if(obj != null){		
			
			var result = obj.result;
			
			if(result == "SUCCESS"){				
				alert("성공하였습니다.");
				$("#f_url").val("http://localhost:8080/"+obj.s_url);
			} else {				
				alert("실패하였습니다.");	
				return;
			}
		}
	}

	
</script>
</head>
<body>
<form id="urlForm" name="urlForm">
<input type="hidden" id="u_no" name="u_no" value="0" />
<input type="hidden" id="s_url" name="s_url" />
<input type="hidden" id="s_col" name="s_col" />

<h1>Shortening URL</h1>
<B>URL : </B><input hidden="hidden" /><input type="text" id="f_url" name="f_url" size="100" onkeyup="fnEnter()" />
<button type="button" onclick="fnBtnClick('s_url')" >확인</button>
<br/><br/>

</form>
</body>
</html>