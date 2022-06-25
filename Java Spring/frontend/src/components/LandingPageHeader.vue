<template>
  <header>
    <div class="center">
      <div class="dropdown">
        <div id="dropdownIcon" class="center">
          <img src="@/assets/images/header/hamburger-menu-icon-white-7.jpg" alt="Burger menu"/>
        </div>
        <div class="dropdown-content" style="left:0;">
          <a href="#">Backup</a>
          <a href="#">Restore</a>
        </div>
      </div>
      <a href="#">
        <div class="center">
          <img src="@/assets/images/header/PXLLogo.png" class="pxlIcon" alt="PXL Logo"/>
          <p id="titel">Stageopdrachten</p>
        </div>
      </a>
    </div>
    <div class="syncFeature center">
      <button type="button" id="syncButton" class="button--loading center"
              @click="sync">
        <img src="@/assets/images/header/syncicon.jpg" alt="sync icon"/>
      </button>
      <div id="syncText">
        <p>Laatst gesynchroniseerd:</p>
        <p>3/03/2022 00:00</p>
      </div>
    </div>
    <div class="center">
      <p id="user">{{ user }}</p>
      <img id="userLoginIcon" @click=handleSignIn() src="@/assets/images/header/icone-utilisateur-gris.png"
           alt="user icon">
    </div>
  </header>
</template>

<script>
export default {
  data() {
    return {
      user: '',
    }
  },
  methods: {
    sync: function () {
      this.$store.dispatch('syncPost');
      this.$store.dispatch('fetchStageopdrachten');
      this.classList.toggle('button--loading');
    },
    async handleSignIn() {
      try {
        const googleUser = await this.$gAuth.signIn();
        if (!googleUser) {
          return null;
        }
        this.user = googleUser.getBasicProfile().getName();

      } catch (error) {
        console.log(error)
        return null;

      }
    }
  }
};
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0px;
  padding: 0px;
}

img {
  height: 40px;
}

a {
  text-decoration: none;
}

header {
  background-color: black;
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;

}

#titel {
  float: right;
  color: white;
  padding-right: 10px;
}

#syncText {
  width: auto;
  height: 50px;
  margin-top: 15px;
  border: 3px dashed transparent;
  vertical-align: middle;
}

#syncText p {
  font-size: 10px;
  color: white;
}


#syncButton {
  height: 50px;
  position: relative;
  background-color: transparent;
  background-repeat: no-repeat;
  border: none;
  cursor: pointer;
  overflow: hidden;
  outline: none;
}


#syncButton img {
  height: 35px;
  transition: all 0.5s;
  background-repeat: no-repeat;
  background-size: 80px 80px;
}

.button--loading img {
  visibility: hidden;
  opacity: 0;
}

.button--loading::after {
  content: "";
  position: absolute;
  width: 20px;
  height: 20px;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  border: 4px solid transparent;
  border-top-color: white;
  border-radius: 50%;
  animation: button-loading-spinner 1s ease infinite;
}

@keyframes button-loading-spinner {
  from {
    transform: rotate(0turn);
  }
  to {
    transform: rotate(1turn);
  }
}

#userLoginIcon {
  padding: 5px;
  margin-right: 10px;
}

#dropdownIcon {
  height: 50px;
  float: left;
  padding: 10px;
}

#dropdownIcon img {
  padding: 5px;
}

#user {
  margin-right: 5px;
  font-size: 12px;
  color: white;
}

.center {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.pxlIcon {
  height: 50px;
  padding-bottom: 10px;
  padding-top: 10px;
  padding-left: 10px;
  padding-right: 5px;
}

a:hover {
  background-color: #505050;
}

#dropdownIcon:hover {
  background-color: #4D4D4D;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  right: 0;
  background-color: black;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 2;
}

.dropdown-content a {
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {
  background-color: #4D4D4D;
}

.dropdown:hover .dropdown-content {
  display: block;
  margin-top: 50px;
}

.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}

</style>
