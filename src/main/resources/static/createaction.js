$(document).ready(function (){
	$("#submitTwo").click(function() {
		let lead = {
				id: parseInt($("#leadId").val()),
				firstName: $("#firstName").val(),
				lastName: $("#lastName").val(),
				email: $("#email").val(),
				title: $("#title").val(),
				proof: $("#proof").val(),
				verdict: $("#verdict").val(),
		};
		let company = {
				id: parseInt($("#companyId").val()),
				name: $("#name").val(),
				sizeproof: $("#employeeproof").val(),
				size: $("#size").val(),
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
		$.ajax('http://localhost:8080/leads/new', {
			method: 'POST',
			data: JSON.stringify(lead),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
		});
		$.ajax('http://localhost:8080/leads/new', {
			method: 'POST',
			data: JSON.stringify(company),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
		});
	})
})