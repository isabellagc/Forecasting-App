/**
 *  Javascript file for CollegeApplication App
 */
document.addEventListener('DOMContentLoaded', function(){
	document.getElementById('commentsInputBox').addEventListener('input', updateStatus);
});


function updateStatus(){
	var text = document.getElementById('commentsInputBox').value;
	if(text != null && text.length != 0){
		document.getElementById('formStatusBox').innerHTML='You have entered ' + text.length + ' characters';
	} else {
		document.getElementById('formStatusBox').innerHTML = '';
	}
};

function popup(){
	alert("Thank you for submitting a review!");
}

