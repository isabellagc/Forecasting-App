/**
 *  Javascript file for CollegeApplication App
 */
document.addEventListener('DOMContentLoaded', function(){
	document.getElementById('collegeNameInputBox').addEventListener('input', updateStatus);
});

function updateStatus(){
	var text = document.getElementById('collegeNameInputBox').value;
	if(text != null && text.length != 0){
		document.getElementById('formStatusBox').innerHTML='You have entered ' + text.length + ' characters';
	} else {
		document.getElementById('formStatusBox').innerHTML = '';
	}
};
