<!DOCTYPE html>
<html>
	<head>
		<title>UnicalDelivery - PDFViewer</title>
		<style>
			#viewpdf{
				height:600px;
			}
		</style>
	</head>
	<body>
	
		<div class="container">
			<div id="viewpdf"></div>
		</div>
	</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.2.4/pdfobject.min.js"></script>
	<script>
		var viewpdf = $("#viewpdf")
		PDFObject.embed("resources/pdf/relazionewebcomputing.pdf",viewpdf);
	
	</script>
</html>