$(document).ready(function () {
	$('form#available-civs button').click(function () {
		var civs = $('form#available-civs input:checkbox:checked').map(function () {
			return $(this).attr('name');
		}).get();

		$.ajax({
			url: '/civs/select',
			type: 'POST',
			data: {'civs': civs},
		})
		.done(function (data) {
			$('#selection-result').text(data);
		})
		.fail(function (result, data) {
			$('#selection-result').text('Error: ' + result.statusText);
		});
	});
});
