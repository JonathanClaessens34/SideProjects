<template>
  <LandingHeader/>
  <stageopdrachten/>
  <MyFooter/>
</template>

<script>
import Stageopdrachten from '@/components/Stageopdrachten.vue';
import LandingHeader from '@/components/LandingPageHeader.vue';
import MyFooter from '@/components/MyFooter.vue';

export default {
  components: {
    Stageopdrachten,
    LandingHeader,
    MyFooter
  },
}
</script>

<style>
html, body {
  margin: 0;
  padding: 0;
  font-family: Helvetica, Arial, Verdana, Tahoma, sans-serif, "Roboto";
}

@media only screen and (max-width: 950px) {
  .headerTitel {
    font-size: 14px;
  }
}

@media only screen and (max-width: 900px) {
  .headerTitel {
    font-size: 13px;
  }
}

@media only screen and (max-width: 850px) {
  .headerTitel {
    font-size: 12px;
  }

  td {
    font-size: 12px;
  }
  #stageopdrachtenVenster {
    margin-right: 50px;
    margin-left: 50px;
  }
}

@media only screen and (max-width: 800px) {
  .headerTitel {
    font-size: 11px;
  }

  td {
    font-size: 11px;
  }

  .sortTriangle {
    height: 8px;
  }

  #stageopdrachtenVenster {
    margin-right: 45px;
    margin-left: 45px;
  }
}

@media only screen and (max-width: 750px) {
  .headerTitel {
    font-size: 10px;
  }

  td {
    font-size: 10px;
  }

  #stageopdrachtenVenster {
    margin-right: 40px;
    margin-left: 40px;
  }
}

@media only screen and (max-width: 700px) {
  .headerTitel {
    font-size: 9px;
  }

  td {
    font-size: 9px;
  }

  .sortTriangle {
    height: 7px;
  }

  #stageopdrachtenVenster {
    margin-right: 35px;
    margin-left: 35px;
  }

  header {
    height: 45px;
  }

  #dropdownIcon {
    height: 45px;
    float: left;
    padding: 7.5px;
  }

  #userLoginIcon {
    padding: 5px;
    margin-right: 7.5px;
  }

  #user {
    margin-right: 4px;
    font-size: 10px;
  }

  .pxlIcon {
    height: 45px;
    padding-bottom: 7.5px;
    padding-top: 7.5px;
    padding-left: 7.5px;
    padding-right: 4px;
  }

  .dropdown:hover .dropdown-content {
    margin-top: 45px;
  }

  .dropdown-content {
    min-width: 100px;
  }

  #syncButton {
    height: 45px;
  }

  #syncButton img {
    height: 30px;
    transition: all 0.5s;
    padding-right: px;
  }

  .button--loading::after {
    width: 15px;
    height: 15px;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    border: 3px solid transparent;
    border-top-color: white;
    border-radius: 50%;
    animation: button-loading-spinner 1s ease infinite;
  }

  #syncText p {
    font-size: 8px;
  }

  #titel {
    font-size: 12px;
  }
}

@media only screen and (max-width: 650px) {
  .headerTitel {
    font-size: 8px;
  }

  td {
    font-size: 8px;
  }

  #stageopdrachtenVenster {
    margin-right: 30px;
    margin-left: 30px;
  }

  .pxlIcon {
    height: 45px;
    padding-bottom: 5px;
    padding-top: 5px;
    padding-left: 5px;
    padding-right: 3px;
    margin: 0px;
  }

  #syncText p {
    font-size: 7px;
  }
}

@media only screen and (max-width: 550px) {
  .headerTitel {
    font-size: 7px;
  }

  td {
    font-size: 7px;
  }

  .sortTriangle {
    height: 6px;
  }


  #stageopdrachtenVenster {
    margin-right: 25px;
    margin-left: 25px;
  }

}

@media only screen and (max-width: 500px) {

  #stageopdrachtenVenster {
    margin-right: 20px;
    margin-left: 20px;
  }

}

</style>