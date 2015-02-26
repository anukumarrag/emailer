<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Mail</title>
         <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
         <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
         <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <%
        String from="",smtp="",port="",username="",password="";
        
        if(session.getAttribute("from")!=null)
            from=(String)session.getAttribute("from");
        
        if(session.getAttribute("smtp")!=null)
            smtp=(String)session.getAttribute("smtp");
        
        if(session.getAttribute("port")!=null)
            port=(String)session.getAttribute("port");
        
        if(session.getAttribute("username")!=null)
            username=(String)session.getAttribute("username");
        
        if(session.getAttribute("password")!=null)
            password=(String)session.getAttribute("password");
        
        
        %>
        
        <div class="container">
        <div class="row">
 
<form id="emailform" role="form" action="Send" method="post" >
<!--    <div class="col-lg-6">
      <div class="well well-sm"><strong><i class="glyphicon glyphicon-ok form-control-feedback"></i> Required Field</strong></div>
      -->
      <div class="form-group well">
        <label for="InputEmail">Setting</label>
        <div class="input-group">
            FROM <input type="text" class="" id="from" name="from" placeholder="from" required  value="<%=from%>" >
          SMTP  <input type="text" class=" " id="smtp" name="smtp" placeholder="smtp" required value="<%=smtp%>" >
          Port  <input type="text" class=" " id="port" name="port" placeholder="587,465,25" value="587" required value="<%=port%>" >
          UserName  <input type="text" class="" id="username" name="username" placeholder="Username" required value="<%=username%>" >
           Password  <input type="text" class="" id="pass" name="password" placeholder="password" required value="<%=password%>" >
          </div>
      </div>
      
      
      <br><br><br><br>
      
      
      <fieldset class="well">
      <div class="form-group">
        <label for="InputEmail">Your Email</label>
        <div class="input-group">
          <input type="text" class="form-control" id="InputEmail" name="emails" placeholder="Enter Email" required  >
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputName">Subject</label>
        <div class="input-group">
          <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputMessage">Message</label>
        <div class="input-group">
          <textarea name="message" id="InputMessage" class="form-control" rows="5" required></textarea>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
<!--      <div class="form-group">
        <label for="InputReal">What is 4+3? (Simple Spam Checker)</label>
        <div class="input-group">
          <input type="text" class="form-control" name="InputReal" id="InputReal" required>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>-->
      <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
         
      
      </fieldset>
       </form>
    </div>

  
</div>

</div>
        
<div class="" style="width: 480px; margin: 0 auto; margin-top: 20px; position: fixed;visibility: hidden;"  id="gif">
         <img src="process.gif" style="display: block; margin: 0 auto; width: 100px; ">
</div>
<script>
    $('#emailform').submit(function() {
    $('#gif').css('visibility', 'visible');
    return true;
});
    
</script>
    </body>
</html>
