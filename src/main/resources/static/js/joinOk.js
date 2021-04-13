let index = {
	init: function() {
		$("#join").on("click", () => {
			this.join();
		});
		$("#searAddrBtn").on("click", () => {
			this.addrs();
		});
	},
	join: function() {
		let data = {
			userId: $("input[name=userId]").val(),
			pwd: $("input[name=pwd]").val(),
			userName: $("input[name=userName]").val(),
			zipcode: $("input[name=zipcode]").val(),
			addr: $("input[name=addr]").val(),
			addrDetail: $("input[name=addrDetail]").val(),
			email: $("input[name=email]").val(),
		};
		$.ajax({
			type:"POST",
			url:"/member/join",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
		}).done(function(res){
			alert("회원가입이 완료 되었습니다.");
			console.log(res);
			location.href="/member/login";
		}).fail(function(error){
			console.log(data);
			console.log(error);
			alert("중복된 아이디 / 중복된 이름 입니다.");
		});
	},
	addrs: function() {
		 new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                
                
                $("[name=zipcode]").val(data.zonecode);
                $("[name=addr]").val(fullRoadAddr);
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open();
	},
}

index.init()