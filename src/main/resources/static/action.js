//$("#submitTwo").click(function (){
//alert('lol');
////http://localhost:8080/DipProject/leads/
////http://localhost:8080/DipProject/companies/
//$.ajax('http://localhost:8080/', {
//method: 'POST',
//data: {
//message: 'lol'
//},
//contentType: 'application/json'
//})
//})
$(document).ready(function (){
	$("#submitTwo").click(function() {

//		Number.parseInt($("#leadId").val()),
		let lead = {
				id: 1,
				firstname: $("#firstname").val(),
				lastname: $("#lastname").val(),
				email: $("#email").val(),
				title: $("#title").val(),
				proof: $("#proof").val(),
		};
//		Number.parseInt($("#companyId").val())
		let company = {
				id: 1,
				name: $("#name").val(),
				employee: $("#employee").val(),
				sizeproof: $("#employeeproof").val(),
				revenue: $("#revenue").val(),
				revenueproof: $("#revenueproof").val(),
				industry: $("#industry").val(),
				phone: $("#phone").val(),
				country: $("#country").val(),
				state: $("#state").val(),
				street: $("#street").val(),
				city: $("#city").val(),
				zip: $("#zip").val(),
		};
		console.log(company);
		console.log(lead);
		$.ajax('http://localhost:8080/DipProject/leads/update', {
			method: 'POST',
			data: JSON.stringify(lead),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
		});
		$.ajax('http://localhost:8080/DipProject/companies/update', {
			method: 'POST',
			data: JSON.stringify(company),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
		});
		alert('Everything is done!');
	})            
})