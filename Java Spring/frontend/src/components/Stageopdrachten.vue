<template>
  <!--searchbar-->
  <div id="searchbarheader" class="center">
    <div class="center" id="searchBox">
      <input id="searchInput" type="text" v-model="searchValue" placeholder="Zoeken..."/>
      <button class="cancelIcon center" type="submit" v-on:click="eraseText()">
        <img src="@/assets/images/searchbar/cross.png" alt="cancel text" />
      </button>
    </div>
    <input class="submitButton" type="submit" value="Bevestigen" @click="BevestigStageopdracht" />
  </div>

  <!--Stageopdrachtenvenster-->
  <div class="stageopdrachtenVenster">
    <!--Header met sorteerfunctie-->
    <header class="stageOpdrachtHeader">
      <h1 id="bedrijfsnaamHeader" class="flexStart marginLeft hover-underline-animation headerTitel sortDropdown" v-on:click="sortByCompanyName">
        <p>Bedrijf</p>
        <img class="triangleHeaderImage" id="triangleCompany" src="@/assets/images/sortbar/dropdowntriangle.png" alt="dropdown triangle"/>
      </h1>
      <h1 id="stageopdrachtTitelHeader" class="flexStart marginLeft hover-underline-animation headerTitel sortDropdown" v-on:click="sortByTitle">
        <p>Titel</p>
        <img class="triangleHeaderImage" id="triangleTitle" src="@/assets/images/sortbar/dropdowntriangle.png" alt="dropdown triangle" />
      </h1>
      <h1 id="periodeHeader" class="flexStart marginLeft headerTitel sortDropdown">
        <p>Periode</p>
        <img class="triangleHeaderImage" src="@/assets/images/sortbar/dropdownarrow.png" alt="dropdown triangle"/>
        <div class="sortDropdownContent">
          <a href="#" @click="sortSemester1">Semester 1</a>
          <a href="#" @click="sortSemester2">Semester 2</a>
          <a href="#" @click="getAlleStageopdrachten">Alle periodes</a>
        </div>
      </h1>
      <h1 id="richtingHeader" class="flexStart marginLeft headerTitel sortDropdown">
        <p>Richting</p>
        <img class="triangleHeaderImage" src="@/assets/images/sortbar/dropdownarrow.png" alt="dropdown triangle"/>
        <div class="sortDropdownContent">
          <a href="#" @click="sortAonFull">AON - Full</a>
          <a href="#" @click="sortAonAI">AON - AI</a>
          <a href="#" @click="sortSWM">SWM</a>
          <a href="#" @click="sortSNB">SNB</a>
          <a href="#" @click="sortICT">Electronica - ICT</a>
          <a href="#" @click="getAlleStageopdrachten">Alle richtingen</a>
        </div>
      </h1>
      <h1 id="statusHeader" class="flexStart marginLeft headerTitel sortDropdown">
        <p>Status</p>
        <img class="triangleHeaderImage" src="@/assets/images/sortbar/dropdownarrow.png" alt="dropdown arrow"/>
        <!--status dropdown-->
        <div class="sortDropdownContent">
          <a href="#" @click="sortNieuwStatus">Nieuw</a>
          <a href="#" @click="sortBevestigdStatus">Bevestigd</a>
          <a href="#" @click="sortInReviewStatus">In review</a>
          <a href="#" @click="sortGereviewdStatus">Gereviewd</a>
          <a href="#" @click="sortOnHoldStatus">On hold</a>
          <a href="#" @click="sortGoedgekeurdStatus">Goedgekeurd</a>
          <a href="#" @click="sortAfgekeurdStatus">Afgekeurd</a>
          <a href="#" @click="sortStudentToegekendStatus">Student toegekend</a>
          <a href="#" @click="getAlleStageopdrachten">Alle statussen</a>
        </div>
      </h1>
      <input type="checkbox" id="SelectAllCheckbox" class="selectAllCheckBox" v-on:click="selectAllCheckboxes"/>
    </header>

    <!--stageopdrachten-->
    <div class="stageOpdracht" v-for="stageopdracht in stageopdrachten" :key="stageopdracht.id ">
      <router-link @click="pushStageopdracht(stageopdracht.id)" to="/detailed" class="stageOpdrachtBalk">
        <div class="statusLabelRed statusLabel" v-if="stageopdracht.currentStatus == 'Afgekeurd'"></div>
        <div class="statusLabelGreen statusLabel" v-else-if="stageopdracht.currentStatus == 'Goedgekeurd'"></div>
        <div class="statusLabelOrange statusLabel" v-else></div>
        <p class="bedrijfsNaam flexStart marginLeft">{{ stageopdracht.companyName }}</p>
        <p class="stageNaam flexStart marginLeft">{{ stageopdracht.title}}</p>
        <p class="richtingNaam flexStart marginLeft">{{ stageopdracht.specialization }}</p>
        <p class="periodeNaam flexStart marginLeft">{{ stageopdracht.period}}</p>
        <p class="statusNaam flexStart marginLeft">{{ stageopdracht.currentStatus }}</p>
      </router-link>
      <!--checkbox-->
      <input v-if="stageopdracht.currentStatus == 'Nieuw'" type="checkbox" v-bind:id="stageopdracht.id" name="Checkbox" class="checkboxField flex"  :checked="checkAll"/>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      searchValue: "",
      checkAll: false,
      stageopdrachten: [],
      companyNameAsc: this.$store.state.companyNameAsc,
      titleAsc: this.$store.state.titleAsc,
    };
  },
  watch: {
      searchValue: function() {
        if (this.searchValue == "" || this.searchValue == null) {
          this.stageopdrachten = this.$store.state.stageopdrachten;
        }
        else {
          console.log(this.searchValue);
          this.stageopdrachten = this.$store.state.stageopdrachten.filter(
            s => s.companyName?.toLowerCase().includes(this.searchValue.toLowerCase()) 
            || s.title?.toLowerCase().includes(this.searchValue.toLowerCase())
            || s.specialization?.toLowerCase().includes(this.searchValue.toLowerCase())
            || s.period?.toLowerCase().includes(this.searchValue.toLowerCase())
            || s.currentStatus?.toLowerCase().includes(this.searchValue.toLowerCase()));
        }
      }
  },
  computed: {

  },
  methods: {
    eraseText() {
      this.searchValue = "";
    },

    sortByCompanyName() {
      var asc = this.companyNameAsc;
      var img = document.getElementById('triangleCompany');
      if (asc) {
          this.stageopdrachten = this.$store.state.stageopdrachten.sort(function (a, b) {
            asc = false;
            img.style.transform = 'rotate(180deg)';
            return a.companyName?.toUpperCase().localeCompare(b.companyName?.toUpperCase());
        });
      }
      else {
          this.stageopdrachten = this.$store.state.stageopdrachten.sort(function (a, b) {
            asc = true;
            img.style.transform = 'rotate(0deg)';
            return b.companyName?.toLowerCase().localeCompare(a.companyName?.toLowerCase());
          
        });   
      }
      this.companyNameAsc = asc;
      this.$store.state.companyNameAsc = asc;
      
    },
    sortByTitle() {
      var asc = this.titleAsc;
      var img = document.getElementById('triangleTitle');
      if (asc) {
          this.stageopdrachten = this.$store.state.stageopdrachten.sort(function (a, b) {
            asc = false;
            img.style.transform = 'rotate(180deg)';
            return a.title?.toLowerCase().localeCompare(b.title?.toLowerCase());
        });
      }
      else {
          this.stageopdrachten = this.$store.state.stageopdrachten.sort(function (a, b) {
            asc = true;
            img.style.transform = 'rotate(0deg)';
            return b.title?.toLowerCase().localeCompare(a.title?.toLowerCase());
          
        });
      }
      this.titleAsc = asc;
      this.$store.state.titleAsc = asc;
    },

    //Sorteer op Periode 
    sortSemester1() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.period.includes("1"));
    },
    sortSemester2() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.period.includes("2"));
    },   
    
    //Sorteer op Richting
    sortAonFull() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.specialization.toLowerCase().includes("full"));
    },
    sortAonAI() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.specialization.toLowerCase().includes("aon - ai"));
    },
    sortSWM() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.specialization.toLowerCase().includes("swm"));
    },
    sortSNB() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.specialization.toLowerCase().includes("snb"));
    },
    sortICT() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.specialization.toLowerCase().includes("ict"));
    },

    //Sorteer op Status
    sortNieuwStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "Nieuw");
    },
    sortBevestigdStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "Bevestigd");
    },
    sortInReviewStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "InReview");
    },
    sortGereviewdStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "Gereviewd");
    },
    sortOnHoldStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "OnHold");
    },
    sortGoedgekeurdStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "Goedgekeurd");
    },
    sortAfgekeurdStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "Afgekeurd");
    },
    sortStudentToegekendStatus() {
      this.stageopdrachten = this.$store.state.stageopdrachten.filter(s => s.currentStatus == "StudentToegekend");
    },
    getAlleStageopdrachten() {
      this.stageopdrachten = this.$store.state.stageopdrachten;
    },
    
    //Naar detailspage
    async pushStageopdracht(id) {
      this.$store.commit('_updateDataReady', false);
      return this.$store.dispatch("fetchDetailedStageopdracht", id).then(() => {
          this.$store.commit('_updateDataReady', true);
        return this.$store.dispatch("fetchPDF", id)
       });
    },
    selectAllCheckboxes(){
      if(document.getElementById("SelectAllCheckbox").checked == true){
       this.checkAll = true;
      }
      else {
        this.checkAll = false;
      }

    },
    BevestigStageopdracht() {
        let checkboxes = document.querySelectorAll('input[name="Checkbox"]:checked');
        let values = [];
        checkboxes.forEach((checkbox) => {
          values.push(checkbox.id);
        });
        console.log(values);

       values.forEach(value =>{ 
         //waar stageopdracht == value(checkboxId) => verander status naar bevestig
          var temporaryStageopdracht = this.$store.state.stageopdrachten.find(s => s.id == value);
          temporaryStageopdracht.currentStatus = "Bevestigd";
          this.$store.dispatch('putStatusMainPage', temporaryStageopdracht);              
         });

    }
  },
  mounted() {
    //Haal data op als state leeg is

    if (!this.$store.state.stageopdrachten.length) {
      this.$store.dispatch('fetchStageopdrachten').then(() => {
        this.stageopdrachten = this.$store.state.stageopdrachten;
      });
    }
    else {
        this.stageopdrachten = this.$store.state.stageopdrachten;
    }

    if (!this.companyNameAsc) {
        var img = document.getElementById('triangleCompany');
        img.style.transform = 'rotate(180deg)';
    }

    if (!this.companyNameAsc) {
        var image = document.getElementById('triangleTitle');
        image.style.transform = 'rotate(180deg)';
    }
  },
};
</script>

<style>

input[type="checkbox"]:hover {
  background-color: #e5e5e5;
  cursor: pointer;
}

input[type="checkbox"]::before {
  content: "";
  width: 0.65em;
  height: 0.65em;
  clip-path: polygon(14% 44%, 0 65%, 50% 100%, 100% 16%, 80% 0%, 43% 62%);
  transform: scale(0);
  transform-origin: bottom left;
  transition: 120ms transform ease-in-out;
  box-shadow: inset 1em 1em var(--form-control-color);
  background-color: white;
}

input[type="checkbox"]:checked::before {
  transform: scale(1);
  background: white;
}

input[type="checkbox"]:checked {
  background: black;
  border: 2px solid black;
}

input[type="checkbox"]:disabled {
  --form-control-color: var(--form-control-disabled);

  color: var(--form-control-disabled);
  cursor: not-allowed;
}
::-webkit-scrollbar {
  width: 15px;
  height: 100px;
}

::-webkit-scrollbar-thumb:hover {
  background: #505050;
}

::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px #e5e5e5;
}

::-webkit-scrollbar-thumb {
  background: black;
}

a p {
  color: #707070;
}

.hover-underline-animation {
  display: inline-block;
  position: relative;
  color: black;
}

.hover-underline-animation:after {
  content: "";
  position: absolute;
  width: 70%;
  transform: scaleX(0);
  height: 2px;
  bottom: 0;
  left: 0;
  background-color: black;
  transform-origin: bottom right;
  transition: transform 0.25s ease-out;
}

.hover-underline-animation:hover:after {
  transform: scaleX(1);
  transform-origin: bottom left;
}

#searchbarheader {
  margin-top: 15px;
  height: 35px;
  width: 90%;
  margin-left: 5%;
}

.sortDropdown {
  position: relative;
  display: inline-block;
  height: 50px;
}

.sortDropdownContent {
  display: none;
  position: absolute;
  background: white;
  border-right: 2px solid #e5e5e5;
  border-bottom: 2px solid #e5e5e5;
  border-left: 2px solid #e5e5e5;
  border-top: 3px solid black;
  min-width: 11.5vw;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  top: 49px;
  z-index: 1;
  border-radius: 0px 0px 6px 6px;
}

.sortDropdownContent a {
  color: black;
  padding: 12px 16px;
  margin: -1px;
  font-size: 14px;
  font-weight: 500;
  border-bottom: 1px solid #e5e5e5;
  text-decoration: none;
  display: block;
}

.sortDropdownContent a:last-child {
  border-bottom: none;
  border-radius: 0px 0px 6px 6px;
  color: white;
  background-color: black;
  
}
.sortDropdownContent a:last-child:hover {
  background-color: #505050;
  
}

.sortDropdownContent a:hover {
  background-color: #e5e5e5;
}

.sortDropdown:hover .sortDropdownContent {
  display: block;
}

.sorteerHeaderDropdownContent {
  display: none;
  position: absolute;
  background-color: black;
  opacity: 0.1;
  min-width: 12vw;
  min-height: 70vh;
  top: 36px;
  left: -6px;
  z-index: 1;
}

.sorteerHeaderDropdown {
  position: relative;
  display: inline-block;
  height: 35px;
}

.sorteerHeaderDropdown:hover .sorteerHeaderDropdownContent {
  display: block;
}

/*stageopdracht css*/
.stageopdrachtenVenster {
  width: 90%;
  margin-left: 5%;
  background: white;
  border: 2px solid #e5e5e5;
  margin-top: 15px;
  overflow-x: hidden;
  overflow-y: auto;
  text-align: justify;
  height: 75vh;
  box-shadow: inset 0 0 0 200px rgba(255, 255, 255, 0.05);
}
.stageOpdrachtHeader {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-areas: "bedrijfHeader titelHeader periodeHeader richtingHeader statusHeader";
  border-bottom: 2px solid #e5e5e5;
  background: white;
  padding-left: 22px;
  padding-right: 15px;
  position: -webkit-sticky; /* Safari */
  position: sticky;
  z-index: 1;
  top: 0;
}
.stageOpdracht {
  display: grid;
  position: relative;
  height: 40px;
  grid-area: stageopdracht;
  grid-template-columns: repeat(5, 1fr);
  grid-template-areas: "stageopdrachtBalk stageopdrachtBalk stageopdrachtBalk stageopdrachtBalk stageopdrachtBalk";
  margin-top: 5px;
  padding-left: 22px;
  padding-right: 15px;
}
.stageOpdrachtBalk {
  display: grid;
  grid-area: stageopdrachtBalk;
  background: #E5E5E5;
  grid-template-columns: repeat(5, 1fr);
  grid-template-areas: "bedrijfNaam stageNaam periodeNaam richtingNaam statusNaam";
}
.stageOpdrachtBalk:hover {
  cursor: pointer;
  background-color: #ccc;
}
.stageOpdrachtBalk p {
  font-size: .9vw;
}
.headerTitel {
  font-size: 16px;
  font-weight: 600;
  color: black;
}
.headerTitel:hover {
  cursor: pointer;
}
.marginLeft {
  margin-left: 5px;
}

p {
  margin: 0;
}
.flex {
  display: flex;
  align-items: center;
}
.flexStart {
  display: flex;
  align-items: center;
  justify-content: flex-start;
}
.triangleHeaderImage {
  width: 10px;
  height: 10px;
  margin-left: 5px;
}
#bedrijfsnaamHeader {
  grid-area: bedrijfHeader;
}
#stageopdrachtTitelHeader {
  grid-area: titelHeader;
}
#richtingHeader {
  grid-area: richtingHeader;
}
#aantalStudentenHeader {
  grid-area: aantalStudentenHeader;
}
#periodeHeader {
  grid-area: periodeHeader;
}
#reviewerHeader {
  grid-area: reviewerHeader;
}
#statusHeader {
  grid-area: statusHeader;
}
.statusLabel {
  width: 7px;
  height: 100%;
  position: absolute;
  left: 15px;
}
.statusLabelOrange {
  background: #FF9900;
}
.statusLabelGreen {
  background: #0DDC1A;
}
.statusLabelRed {
  background: #FE0000;
}
.bedrijfsNaam {
  grid-area: bedrijfNaam;
  white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
  width: 90%;
}
.stageNaam {
  grid-area: stageNaam;
  white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis; 
  width: 90%;
}
.richtingNaam {
  grid-area: richtingNaam;
}
.aantalStudentenNaam {
  grid-area: aantalStudenten;
  margin-left:40%; 
}
.periodeNaam {
  grid-area: periodeNaam;
}
.reviewerNaam {
  grid-area: reviewerNaam;
}
.statusNaam {
  grid-area: statusNaam;
  margin-right: 20px;
}
.checkboxField {
  grid-area: checkboxInput;
  position: absolute;
  right: 15px;
  background: black;
  top: 1.5px;
  -webkit-appearance: none;
  appearance: none;
  background-color: white;
  font: inherit;
  width: 40px;
  height: 40px;
  border: 2px solid #ccc;
  transform: translateY(-0.075em);
  display: grid;
  place-content: center;
}

.selectAllCheckBox {
  grid-area: checkboxInput;
  position: absolute;
  right: 15px;
  background: black;
  top: 5px;
  -webkit-appearance: none;
  appearance: none;
  background-color: white;
  font: inherit;
  width: 40px;
  height: 40px;
  border: 2px solid #ccc;
  transform: translateY(-0.075em);
  display: grid;
  place-content: center;
}

.cancelIcon {
  height: 35px;
  width: 35px;
  border-top: 2px solid #E5E5E5;
  border-right: 2px solid #E5E5E5;
  border-bottom: 2px solid #E5E5E5;
  border-left: none;
  padding: 3px;
}

.cancelIcon:hover {
  cursor: pointer;
}

#searchBox {
  height: 35px;
  -webkit-transition: 0.3s;
  transition: 0.3s;
}

.cancelIcon img {
  height: 20px;
  padding-left: 5px;
}

#searchInput {
  height: 35px;
  width: 200px;
  font-size: 16px;
  box-sizing: border-box;
  border-top: 2px solid #E5E5E5;
  border-right: none;
  border-bottom: 2px solid #E5E5E5;
  border-left: 2px solid #E5E5E5;
  padding-left: 5px;
  -webkit-transition: 0.3s;
  transition: 0.3s;
  outline: none;
}

#searchInput:focus {
  font-size: 16px;
}

button {
  background: white;
  -webkit-transition: 0.3s;
  transition: 0.3s;
}

.submitButton:hover {
  background: #505050;
}

button:hover {
  background: #E5E5E5;
}

input[type=submit] {
  background-color: black;
  border: none;
  color: white;
  height: 35px;
  width: 120px;
  text-decoration: none;
  cursor: pointer;
}
</style>
