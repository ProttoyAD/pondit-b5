<%--
  Created by IntelliJ IDEA.
  User: YOGA
  Date: 5/3/2023
  Time: 6:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/profile.css"/>
</head>
<body>
<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
                <div class="card">
                    <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
                        <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp"
                                 alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                                 style="width: 150px; z-index: 1">
                            <button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                                    style="z-index: 1;">
                                Edit profile
                            </button>
                        </div>
                        <div class="ms-3" style="margin-top: 130px;">
                            <h5>${user.name}</h5>
                            <p>New York</p>
                        </div>
                    </div>
                    <div class="p-4 text-black" style="background-color: #f8f9fa;">
                        <div class="d-flex justify-content-end text-center py-1">
                            <div>
                                <p class="mb-1 h5">253</p>
                                <p class="small text-muted mb-0">Photos</p>
                            </div>
                            <div class="px-3">
                                <p class="mb-1 h5">1026</p>
                                <p class="small text-muted mb-0">Followers</p>
                            </div>
                            <div>
                                <p class="mb-1 h5">478</p>
                                <p class="small text-muted mb-0">Following</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-body p-4 text-black">
                        <div class="mb-5">
                            <p class="lead fw-normal mb-1">About</p>
                            <div class="p-4" style="background-color: #f8f9fa;">
                                <p class="font-italic mb-1">Web Developer</p>
                                <p class="font-italic mb-1">Lives in New York</p>
                                <p class="font-italic mb-0">Photographer</p>
                            </div>
                        </div>
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0">Recent photos</p>
                            <p class="mb-0"><a href="#!" class="text-muted">Show all</a></p>
                        </div>
                        <div class="row g-2">
                            <div class="col mb-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(112).webp"
                                     alt="image 1" class="w-100 rounded-3">
                            </div>
                            <div class="col mb-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(107).webp"
                                     alt="image 1" class="w-100 rounded-3">
                            </div>
                        </div>
                        <div class="row g-2">
                            <div class="col">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(108).webp"
                                     alt="image 1" class="w-100 rounded-3">
                            </div>
                            <div class="col">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(114).webp"
                                     alt="image 1" class="w-100 rounded-3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
