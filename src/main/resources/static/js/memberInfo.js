function move(){
	$(".list").on("click",function(){
		location.href="/member/admin";
	});
	
	$(".update").on("click",function(){
		let no = $("#memberNo").text();
		location.href="/member/update/"+no;
	});
	
	$(".deleteOk").on("click",function(){
		let conf = confirm("삭제하시겠습니까?");
		let no = $("#memberNo").text();
		if(conf==true)
			location.href="/member/deleteOk/"+no;
		else
			return false;
	});
}
move();


