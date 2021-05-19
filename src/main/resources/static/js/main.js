;(function(){

    var body = document.querySelector("body");
    
    var closesAttr = function(item, attr){
        var node = item;

        while(node){
            var attrValue = node.getAttribute(attr);
            if(attrValue){
                return attrValue;
            }

            node = node.parentElement;
         
        }

        return null;
    }

    var closesItemByClass = function(item, className){
        var node = item;

        while(node){
            if(node.classList.contains(className)){
                return node;
            }

            node = node.parentElement;
         
        }

        return null;
    }

    var showPopup = function(target){
        target.classList.add('is_active');
    }
    
    var closePopup = function(target){
        target.classList.remove('is_active');
    }

    var toggleScroll = function (){
        body.classList.toggle('no-scroll');
    }

    body.addEventListener('click', function (e){
        var target = e.target;
        var popupClass = closesAttr(target, 'data-popup');

        if(popupClass === null){
            return;
        }

        e.preventDefault();
        var popup = document.querySelector('.' + popupClass);

        if(popup){
            showPopup(popup);
            toggleScroll();
        }

      
    })

    body.addEventListener('keydown', function (e){
        if(e.keyCode != 27){
            return;
        }
        var popup = document.querySelector('.accpopup.is_active');

        if(popup){
            closePopup(popup);
            toggleScroll();
        }
    })

    body.addEventListener('click', function (e){
       var target = e.target;
       if(target.classList.contains('close') ||
        target.classList.contains('accpopup')){

        var popup = closesItemByClass(target, 'accpopup');
        closePopup(popup);
        toggleScroll();
        }
    })
})();

document.addEventListener('DOMContentLoaded', function(){
    let form = document.getElementById('form');
    form.addEventListener('submit', formSend);

    async function formSend(e){
        e.preventDefault();

        let error = formValidate(form);
        if(error == 0){

        }else{
            alert("Необходимо правильно заполнить обязательные поля")
        }

    }
       function formValidate(form){
           let error = 0;
           let formReq = document.querySelectorAll('._req');
           for(let index = 0; index < formReq.length; index++){
               const input = formReq[index];
               formRemoveError(input);
               if(input.classList.contains('_email')){
                   if(emailTest(input)){
                       formAddError(input);
                       error++;
                   }
               }else if(input.classList.contains('_name')){
                if(nameTest(input)){
                    formAddError(input);
                    alert("Введите коректное имя!");
                    error++;
                }
               }
               else if(input.getAttribute("type") == "checkbox" && input.checked == false){
                   formAddError(input);
                   error++;
               }else{
                   if(input.value == ""){
                       formAddError(input);
                       error++;
                   }
               }
           }
           return error;
       }
       function formAddError(input){
           input.parentElement.classList.add('_error');
           input.classList.add('_error');
       }
       function formRemoveError(input){
           input.parentElement.classList.remove('_error');
           input.classList.remove('_error');
       }

       function nameTest(input){
        var name = input.value;
        console.log(name.length);
        if(name.length == 0)
        {
            return true;
        }
        var sim = "!@#$%^&*()_+№;%:?*_+1234567890";
        for(var i = 0; i < name.length; i++){
            for(var j = 0; j < sim.length; j++){
                if(name[i] == sim[j])
                {
                    return true;
                }else if(i > 0 && (name[i].toUpperCase()==name[i]) == true){
                    return true;
                }
            }
        }
        return false;
    }

    function emailTest(input){
        return !/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,8})+$/.test(input.value);
    }

})

