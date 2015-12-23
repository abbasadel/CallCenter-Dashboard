'use strict';

myApp.factory('NotificationService', function($http) {

    return {
        push: function(content,title,color,iconSmall){
//            alert();
            $.smallBox({
                title : title,
                content : content,
                color : color,
                iconSmall : iconSmall,
                timeout : 4000
                //"fa fa-thumbs-up bounce animated"
            });
        },

        success: function(content,title){
            if(typeof title === 'undefined'){
                this.push(content,"Successful Operation","#739E73","fa fa-thumbs-up bounce animated");
            }else{
                this.push(content,title,"#739E73","fa fa-thumbs-up bounce animated");
            }
//            console.log("content: "+content,"title: "+title);
        },
        error: function(content,title){
            if(typeof title === 'undefined' && typeof content === 'undefined'){
                title="connection error";
                content="Please Check Your Internet Connection";
            }
            this.push(content,title,"#C46A69","fa fa-thumbs-down bounce animated");
            console.log(title);
        }

    };

});
	