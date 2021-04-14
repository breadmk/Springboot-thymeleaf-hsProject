//let index = {
//	init:function(){
//		$(".info").on("click",()=>{
//			this.row();			
//		});
//	},
//	row: function(){
//		
//		console.log(no);
////		location.href='/member/info';
//	}
//	
//}
//
//index.init();
//

function memberNo(){
	$(".info").on("click",function(){
		let no = $(this).find(".memberNo").val();
		location.href="/member/info/"+no;
	});
}
memberNo();


