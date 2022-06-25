<template>
  <!--Detailspage header-->
  <header>
    <div class="center">
      <div class="dropdown">
        <div id="dropdownIcon" class="center">
          <img
              src="@/assets/images/header/hamburger-menu-icon-white-7.jpg"
              alt="Burger menu"
          />
        </div>
        <div class="dropdown-content" style="left: 0">
          <a href="#" @click="openUrl()">PDF downloaden</a>
        </div>
      </div>
      <router-link to="/">
        <div class="center">
          <img src="@/assets/images/header/PXLLogo.png" class="pxlIcon" alt="pxl icon"/>
          <p id="titel">Stageopdrachten</p>
        </div>
      </router-link>
    </div>
  </header>

  <!--Back arrow-->
  <router-link to="/" id="backArrow">
    <img src="@/assets/images/detailedPage/arrow-icon-1.jpg" alt="back arrow"/>
  </router-link>

  <!--Detailspage content-->
  <div v-if="!this.$store.state.dataReady" class="loading">Loading</div>
  <div v-if="!this.$store.state.dataReady" class="button--loading--detailsPage"></div>
  <div class="detailsPageInformationGrid" v-if="this.$store.state.dataReady">
    <!--Titel stage-->
    <h1 class="stageopdrachtTitel topRow">
      {{ this.$store.state.stageopdrachtDetailsPage.title }} <span>{{ this.$store.state.stageopdrachtDetailsPage.specialization }}</span>
    </h1>
    <!--Studentenlijst-->
    <div id="studenToekennenBox" class="flexStart topRow">
    <select id="selecteerStudentenBox">
      <option value="" disabled selected>Student toekennen</option>
      <option v-for="student of $store.state.studenten" v-bind:key="student">
        {{ student.voornaam }} {{ student.naam }}
      </option>
      
    </select>
    <input type="submit" value="+" id="studentToekennenButton" @click="StudentToekennen">
    </div>
    
    <!--Status-->
    <div id="statusBox" class="topRow">
      <div class="statusLabelRed status" v-if="this.$store.state.stageopdrachtDetailsPage.status == 'Afgekeurd'"></div>
      <div class="statusLabelGreen status"
           v-else-if="this.$store.state.stageopdrachtDetailsPage.status == 'Goedgekeurd'"></div>
      <div class="statusLabelOrange status" v-else></div>
      <p>{{ this.$store.state.stageopdrachtDetailsPage.status }}</p>
    </div>
    <!--Bedrijfsinformatie-->
    <div class="bedrijfsInformatie informatieBlock">
      <h2 class="contentTitel flexStartNoCenter">
        Bedrijfsinformatie
        <div id="bedrijfsInformatie" v-if="!editCompanyInformation" class="edit">
          <img
              class="pencil"
              src="@/assets/images/detailedPage/pencil.png"
              alt="edit pencil"
              @click="editCompanyInformation = true; editCompany =true; enableEditing()"
              @mouseover="showInfo['Bedrijfsinformatie'] = true"
              @mouseleave="showInfo['Bedrijfsinformatie'] = false, showInfo['CancelBedrijfsinformatie'] = false, showInfo['SaveBedrijfsinformatie'] = false"
          />
          <p class="info" v-if="showInfo['Bedrijfsinformatie']">Edit</p>
        </div>
        <div class="edit" v-if="editCompanyInformation">
          <img class="pencil" src="@/assets/images/detailedPage/cross.png"
               alt="edit pencil"
               @click="editCompanyInformation = false; disableEditing()"
               @mouseover="showInfo['CancelBedrijfsinformatie'] = true"
               @mouseleave="showInfo['CancelBedrijfsinformatie'] = false, showInfo['SaveBedrijfsinformatie'] = false, showInfo['Bedrijfsinformatie'] = false"/>
          <img class="pencil" src="@/assets/images/detailedPage/checkmark.png"
               alt="edit pencil"
               @click="editCompanyInformation = false; saveCompany =true; saveEdit()"
               @mouseover="showInfo['SaveBedrijfsinformatie'] = true"
               @mouseleave="showInfo['Bedrijfsinformatie'] = false, showInfo['CancelBedrijfsinformatie'] = false, showInfo['SaveBedrijfsinformatie'] = false"/>
          <p class="info" v-if="showInfo['CancelBedrijfsinformatie']">Cancel</p>
          <p class="info" v-if="showInfo['SaveBedrijfsinformatie']">Save</p>
        </div>
      </h2>

      <div class="flexStart marginTop">
        <p class="firstParagraph">Bedrijfsnaam:</p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.name }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempCompany"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Adres:</p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.street }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempAdress"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Locatie:</p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.postal }}
          {{ this.$store.state.stageopdrachtDetailsPage.company.city }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempLocation"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Aantal medewerkers:</p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.numberOfEmployees }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempEmployees"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Aantal IT-medewerkers:</p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.numberOfITEmployees }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempItEmployees"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">
          Aantal IT-medewerkers die student technisch kunnen begeleiden:
        </p>
        <p class="secondParagraph" v-if="!editCompanyInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.company.numberOfEAEmployees }}</p>
        <input v-if="editCompanyInformation" type="text" v-model="tempEaEmployees"/>
      </div>
    </div>
    <!--ContactpersoonInformatie-->
    <div class="contactpersoonInformatie informatieBlock">
      <h2 class="contentTitel flexStartNoCenter">
        Contactpersoon
        <div v-if="!editContactInformation" class="edit">
          <img class="pencil"
               src="@/assets/images/detailedPage/pencil.png"
               alt="edit pencil"
               @click="editContactInformation = true; editContact =true; enableEditing()"
               @mouseover="showInfo['Contactpersoon'] = true"
               @mouseleave="showInfo['Contactpersoon'] = false, showInfo['CancelContactpersoon'] = false, showInfo['SaveContactpersoon'] = false"/>
          <p class="info" v-if="showInfo['Contactpersoon']">Edit</p>
        </div>
        <div class="edit" v-if="editContactInformation">
          <img class="pencil"
               src="@/assets/images/detailedPage/cross.png"
               alt="edit pencil"
               @click="editContactInformation = false; disableEditing()"
               @mouseover="showInfo['CancelContactpersoon'] = true"
               @mouseleave="showInfo['CancelContactpersoon'] = false, showInfo['SaveContactpersoon'] = false, showInfo['Contactpersoon'] = false"/>
          <img class="pencil"
               src="@/assets/images/detailedPage/checkmark.png"
               alt="edit pencil"
               @click="editContactInformation = false; saveContact =true; saveEdit()"
               @mouseover="showInfo['SaveContactpersoon'] = true"
               @mouseleave="showInfo['Contactpersoon'] = false, showInfo['CancelContactpersoon'] = false, showInfo['SaveContactpersoon'] = false"/>
          <p class="info" v-if="showInfo['CancelContactpersoon']">Cancel</p>
          <p class="info" v-if="showInfo['SaveContactpersoon']">Save</p>
        </div>
      </h2>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Titel:</p>
        <p class="secondParagraph" v-if="!editContactInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.contactPerson.title }}</p>
        <input v-if="editContactInformation" type="text" v-model="tempContTitle"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Naam:</p>
        <p class="secondParagraph" v-if="!editContactInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.contactPerson.name }}</p>
        <input v-if="editContactInformation" type="text" v-model="tempContName"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Voornaam:</p>
        <p class="secondParagraph" v-if="!editContactInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.contactPerson.firstName }}</p>
        <input v-if="editContactInformation" type="text" v-model="tempContFirstName"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Telefoon:</p>
        <p class="secondParagraph" v-if="!editContactInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.contactPerson.phoneNumber }}</p>
        <input v-if="editContactInformation" type="text" v-model="tempContTel"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">E-mail:</p>
        <p class="secondParagraph" v-if="!editContactInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.contactPerson.email }}</p>
        <input v-if="editContactInformation" type="text" v-model="tempContEmail"/>
      </div>
    </div>
    <!--Bedrijfspromotor informatie-->
    <div class="bedrijfsPromotorInformatie informatieBlock">
      <h2 class="contentTitel flexStartNoCenter">
        Bedrijfspromotor
        <div v-if="!editSupervisorInformation" class="edit">
          <img
              class="pencil"
              src="@/assets/images/detailedPage/pencil.png"
              alt="edit pencil"
              @click="editSupervisorInformation = true; editSupervisor =true; enableEditing()"

              @mouseover="showInfo['Bedrijfspromotor'] = true"
              @mouseleave="showInfo['Bedrijfspromotor'] = false, showInfo['CancelBedrijfspromotor'] = false, showInfo['SaveBedrijfspromotor'] = false"/>
          <p class="info" v-if="showInfo['Bedrijfspromotor']">Edit</p>
        </div>
        <div class="edit" v-if="editSupervisorInformation">
          <img class="pencil"
               src="@/assets/images/detailedPage/cross.png"
               alt="edit pencil"
               @click="editSupervisorInformation = false; disableEditing();"
               @mouseover="showInfo['CancelBedrijfspromotor'] = true"
               @mouseleave="showInfo['CancelBedrijfspromotor'] = false, showInfo['SaveBedrijfspromotor'] = false, showInfo['Bedrijfspromotor'] = false"/>
          <img class="pencil"
               src="@/assets/images/detailedPage/checkmark.png"
               alt="edit pencil"
               @click=" editSupervisorInformation = false; saveSupervisor =true; saveEdit()"
               @mouseover="showInfo['SaveBedrijfspromotor'] = true"
               @mouseleave="showInfo['Bedrijfspromotor'] = false, showInfo['CancelBedrijfspromotor'] = false, showInfo['SaveBedrijfspromotor'] = false"/>
          <p class="info" v-if="showInfo['CancelBedrijfspromotor']">Cancel</p>
          <p class="info" v-if="showInfo['SaveBedrijfspromotor']">Save</p>
        </div>
      </h2>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Titel:</p>
        <p class="secondParagraph" v-if="!editSupervisorInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.supervisor.title }}</p>
        <input v-if="editSupervisorInformation" type="text" v-model="tempPromTitle"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Naam:</p>
        <p class="secondParagraph" v-if="!editSupervisorInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.supervisor.name }}</p>
        <input v-if="editSupervisorInformation" type="text" v-model="tempPromName"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Voornaam:</p>
        <p class="secondParagraph" v-if="!editSupervisorInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.supervisor.firstName }}</p>
        <input v-if="editSupervisorInformation" type="text" v-model="tempPromFirstName"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">Telefoon:</p>
        <p class="secondParagraph" v-if="!editSupervisorInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.supervisor.phoneNumber }}</p>
        <input v-if="editSupervisorInformation" type="text" v-model="tempPromTel"/>
      </div>
      <div class="flexStart marginTop">
        <p class="firstParagraph">E-mail:</p>
        <p class="secondParagraph" v-if="!editSupervisorInformation">
          {{ this.$store.state.stageopdrachtDetailsPage.supervisor.email }}</p>
        <input v-if="editSupervisorInformation" type="text" v-model="tempPromEmail"/>
      </div>
    </div>
  </div>
  <div v-if="this.$store.state.dataReady" id="stageomschrijving">
    <h2 class="informatieBlockTitel">Stageomschrijving</h2>
    <div id="stageomschrijvingTextBox">
      <p>{{ this.$store.state.stageopdrachtDetailsPage.description }}</p>
    </div>
  </div>
  <div class="flexEnd">
  <input id="goedkeurenButton" class="submitButton" type="submit" v-if="this.$store.state.dataReady" value="Goedkeuren" @click="GoedkeurenStageopdracht" />
  <input id="afkeurenButton" class="submitButton" type="submit" v-if="this.$store.state.dataReady" value="Afkeuren" @click="AfkeurenStageopdracht" />
  </div>
  <!--Mail venster-->
  <div class="mailVenster" v-if="this.$store.state.dataReady">
    <div class="berichtenLijst">
      <select id="selecteerReviewerBox">
        <option value="" disabled selected>Selecteer reviewer</option>
        <!--<option v-for="reviewer of $store.state.studenten" v-bind:key="student">
          {{ student.voornaam }} {{ student.naam }}
      </option>-->
      </select>
      <!--<div v-for="bericht in this.$state.store.berichten" :id=>
      </div>-->
    </div> 
    <div class="berichtVenster">
      <h3 class="titelBericht">Titel</h3>
      <h5 class="afzender">From: Email</h5>
      <div class="berichtInhoud">Sectie 1.10.32 van "de Finibus Bonorum et Malorum", geschreven door Cicero in 45 v.Chr.
"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"

1914 vertaling door H. Rackham
"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"

Sectie 1.10.33 van "de Finibus Bonorum et Malorum", geschreven door Cicero in 45 v.Chr.
"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."

1914 vertaling door H. Rackham
"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."</div>
    </div>
    <div class="antwoordVenster">
      <textarea class="antwoord" placeholder="Typ hier uw antwoord"></textarea>
      <input class="pdfToevoegenCheckBox" type="checkbox"/>
      <button class="verzendKnop">Verzenden</button>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      editCompanyInformation: false,
      editContactInformation: false,
      editSupervisorInformation: false,
      editCompany: false,
      editContact: false,
      editSupervisor: false,
      saveCompany: false,
      saveContact: false,
      saveSupervisor: false,
      tempCompany: null,
      tempAdress: null,
      tempLocation: null,
      tempEmployees: null,
      tempItEmployees: null,
      tempEaEmployees: null,
      tempContTitle: null,
      tempContName: null,
      tempContFirstName: null,
      tempContTel: null,
      tempContEmail: null,
      tempPromTitle: null,
      tempPromName: null,
      tempPromFirstName: null,
      tempPromTel: null,
      tempPromEmail: null,
      tempValue: null,
      Expanded: false,
      showInfo:
          {
            'Bedrijfsinformatie': false,
            'Contactpersoon': false,
            'Bedrijfspromotor': false,
            'CancelBedrijfsinformatie': false,
            'SaveBedrijfsinformatie': false,
            'CancelContactpersoon': false,
            'SaveContactpersoon': false,
            'CancelBedrijfspromotor': false,
            'SaveBedrijfspromotor': false,
          },

      stageopdracht: this.$store.state.stageopdrachtDetailsPage,
    };
  },

  computed: {},
  methods: {
    //place all the variables in a temp variable to be edited
    enableEditing: function () {
      if (this.editCompanyInformation == true && this.editCompany == true) {
        this.tempCompany = this.$store.state.stageopdrachtDetailsPage.company.name;
        this.tempAdress = this.$store.state.stageopdrachtDetailsPage.company.street;
        this.tempLocation = this.$store.state.stageopdrachtDetailsPage.company.postal + " " + this.$store.state.stageopdrachtDetailsPage.company.city;
        this.tempEmployees = this.$store.state.stageopdrachtDetailsPage.company.numberOfEmployees;
        this.tempItEmployees = this.$store.state.stageopdrachtDetailsPage.company.numberOfITEmployees;
        this.tempEaEmployees = this.$store.state.stageopdrachtDetailsPage.company.numberOfEAEmployees;
        this.editCompany = false;
      }
      if (this.editContactInformation == true && this.editContact == true) {
        this.tempContTitle = this.$store.state.stageopdrachtDetailsPage.contactPerson.title;
        this.tempContName = this.$store.state.stageopdrachtDetailsPage.contactPerson.name;
        this.tempContFirstName = this.$store.state.stageopdrachtDetailsPage.contactPerson.firstName;
        this.tempContTel = this.$store.state.stageopdrachtDetailsPage.contactPerson.phoneNumber;
        this.tempContEmail = this.$store.state.stageopdrachtDetailsPage.contactPerson.email;
        this.editContact = false;
      }
      if (this.editSupervisorInformation == true && this.editSupervisor == true) {
        this.tempPromTitle = this.$store.state.stageopdrachtDetailsPage.supervisor.title;
        this.tempPromName = this.$store.state.stageopdrachtDetailsPage.supervisor.name;
        this.tempPromFirstName = this.$store.state.stageopdrachtDetailsPage.supervisor.firstName;
        this.tempPromTel = this.$store.state.stageopdrachtDetailsPage.supervisor.phoneNumber;
        this.tempPromEmail = this.$store.state.stageopdrachtDetailsPage.supervisor.email;
        this.editSupervisor = false;
      }
    },

    //when cancel is clicked all temp variables will be null and will not change anything
    disableEditing: function () {
      if (this.editCompanyInformation == false) {
        this.tempCompany = null;
        this.tempAdress = null
        this.tempLocation = null;
        this.tempEmployees = null;
        this.tempItEmployees = null;
        this.tempEaEmployees = null;
      }
      if (this.editContactInformation == false) {
        this.tempContTitle = null;
        this.tempContName = null;
        this.tempContFirstName = null;
        this.tempContTel = null;
        this.tempContEmail = null;
      }
      if (this.editSupervisorInformation == false) {
        this.tempPromTitle = null;
        this.tempPromName = null;
        this.tempPromFirstName = null;
        this.tempPromTel = null;
        this.tempPromEmail = null;
      }
    },

    //when save is clicked all temp variables wil update the database with the changed values
    saveEdit: function () {
      if (this.editCompanyInformation == false && this.saveCompany == true) {
        //Update content op page.

        this.$store.state.stageopdrachtDetailsPage.company.name = this.tempCompany;
        this.$store.state.stageopdrachtDetailsPage.company.street = this.tempAdress;
        this.$store.state.stageopdrachtDetailsPage.company.postal = this.tempLocation.substring(0, this.tempLocation.indexOf(' '));
        this.$store.state.stageopdrachtDetailsPage.company.city = this.tempLocation.substring(this.tempLocation.indexOf(' ') + 1);
        this.$store.state.stageopdrachtDetailsPage.company.numberOfEmployees = this.tempEmployees;
        this.$store.state.stageopdrachtDetailsPage.company.numberOfITEmployees = this.tempItEmployees;
        this.$store.state.stageopdrachtDetailsPage.company.numberOfEAEmployees = this.tempEaEmployees;
        //Send PUT Request

        this.$store.dispatch('putCompanyDetailed', {
          id: this.$store.state.stageopdrachtDetailsPage.company.id,
          postal: this.tempLocation.substring(0, this.tempLocation.indexOf(' ')),
          name: this.tempCompany,
          street: this.tempAdress,
          city: this.tempLocation.substring(this.tempLocation.indexOf(' ') + 1),
          locationInternshipStreet: this.tempAdress,
          locationInternshipCity:  this.tempLocation.substring(this.tempLocation.indexOf(' ') + 1),
          numberOfEmployees: this.tempEmployees,
          numberOfEAEmployees: this.tempEaEmployees,
          numberOfITEmployees: this.tempItEmployees
        });
        this.$store.state.stageopdrachten.find(s => s.id == this.$store.state.stageopdrachtDetailsPage.id).companyName = this.tempCompany;
        this.saveCompany = false;
      }
      if (this.editContactInformation == false && this.saveContact == true) {

        this.$store.state.stageopdrachtDetailsPage.contactPerson.title = this.tempContTitle;
        this.$store.state.stageopdrachtDetailsPage.contactPerson.Name = this.tempContName;
        this.$store.state.stageopdrachtDetailsPage.contactPerson.firstName = this.tempContFirstName;
        this.$store.state.stageopdrachtDetailsPage.contactPerson.phoneNumber = this.tempContTel;
        this.$store.state.stageopdrachtDetailsPage.contactPerson.email = this.tempContEmail;

        this.$store.dispatch('putContactPersonDetailed', {
          id: this.$store.state.stageopdrachtDetailsPage.contactPerson.id,
          title: this.tempContTitle,
          name: this.tempContName,
          firstname: this.tempContFirstName,
          phoneNumber: this.tempContTel,
          email: this.tempContEmail
        })
        this.saveContact = false
      }
      if (this.editSupervisorInformation == false  && this.saveSupervisor == true) {
        this.$store.state.stageopdrachtDetailsPage.supervisor.title = this.tempPromTitle;
        this.$store.state.stageopdrachtDetailsPage.supervisor.Name = this.tempPromName;
        this.$store.state.stageopdrachtDetailsPage.supervisor.firstName = this.tempPromFirstName;
        this.$store.state.stageopdrachtDetailsPage.supervisor.phoneNumber = this.tempPromTel;
        this.$store.state.stageopdrachtDetailsPage.supervisor.email = this.tempPromEmail;

        this.$store.dispatch('putSupervisorDetailed', {
          id: this.$store.state.stageopdrachtDetailsPage.supervisor.id,
          title: this.tempPromTitle,
          name: this.tempPromName,
          firstName: this.tempPromFirstName,
          phoneNumber: this.tempPromTel,
          email: this.tempPromEmail
        })
        this.saveSupervisor = false;
      }
    },
    openUrl:function (){
      location.href = this.$store.state.Pdf;
    },
    GoedkeurenStageopdracht() {
      this.$store.state.stageopdrachtDetailsPage.status = "Goedgekeurd";
      this.stageopdracht = this.$store.state.stageopdrachtDetailsPage;
      this.$store.state.stageopdrachten.find(s => s.id == this.stageopdracht.id).currentStatus = "Goedgekeurd";
      this.$store.dispatch('putStatusDetailedPage', this.stageopdracht);
    },
    AfkeurenStageopdracht() {
      this.$store.state.stageopdrachtDetailsPage.status = "Afgekeurd";
      this.stageopdracht = this.$store.state.stageopdrachtDetailsPage;
      this.$store.state.stageopdrachten.find(s => s.id == this.stageopdracht.id).currentStatus = "Afgekeurd";
      this.$store.dispatch('putStatusDetailedPage', this.stageopdracht);
    }
  },
  mounted() {
    this.$store.dispatch("fetchStudenten");
    this.stageopdracht = this.$store.state.stageopdrachtDetailsPage;
    console.log("enetered mounted details" + this.$store.state.stageopdrachtDetailsPage);
  },
};
</script>
<style>
html {
  scroll-behavior: smooth;
}

#backArrow {
  background: transparent;
  position: absolute;
  top: 73px;
  left: 10px;
}

.informatieBlock .firstParagraph {
  display: block;
}

.flexStartNoCenter {
  display: flex;
  justify-content: flex-start;
}

.detailsPageInformationGrid {
  display: grid;
  grid-template-columns: 2fr 1fr 1fr;
  grid-template-areas: "stageopdrachtTitel studentenlijst status";
  width: 90%;
  margin-left: 5%;
}

.stageopdrachtTitel {
  grid-area: stageopdrachtTitel;
  position: relative;
}

.stageopdrachtTitel span {
  position: absolute;
  opacity: 0.25;
  color: #ccc;
  z-index: -1;
  top: -30px;
  left: 50px;
  font-size: 8em;
  font-weight: 600;
}

.marginTop {
  margin-top: 2px;
}

.centerMid {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 30px;
}

.contentTitel {
  margin-bottom: 20px;
  margin-right: 20px;
}

#studenToekennenBox {
  grid-area: studentenlijst;
}
#studentToekennenButton {
  width: 40px;
}

#studentToekennenButton:hover {
  background: #4d4d4d;
}
#selecteerStudentenBox {
  height: 35px;
  width: 70%;
  font-size: 16px;
  box-sizing: border-box;
  border: 2px solid #e5e5e5;
  padding-left: 5px;
  -webkit-transition: 0.3s;
  transition: 0.3s;
  outline: none;
}

#statusBox {
  grid-area: status;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #707070;
  border: 2px solid #e5e5e5;
  background: #e5e5e5;
  opacity: 1;
  height: 35px;
  text-align: center;
  position: relative;
}

.topRow {
  margin-bottom: 20px;
  margin-top: 20px;
}

.pencil {
  width: 15px;
  height: 15px;
}

.pencil:hover {
  cursor: pointer;
}

.firstParagraph {
  margin-right: 5px;
  color: #707070;
  opacity: 1;
  font-size: 14px;
  font-weight: 400;
  display: none;
  transition: width 2s linear 1s;
}

.secondParagraph {
  font-weight: 400;
  color: black;
  font-size: 14px;
}

.status {
  position: absolute;
  top: -2px;
  left: -2px;
  height: 35px;
  width: 7px;
}

#stageomschrijving {
  width: 90%;
  margin-left: 5%;
  margin-top: 20px;
  position: relative;
}

#stageomschrijving div {
  height: auto;
  margin-top: 20px;
  text-align: justify;
  overflow: hidden;
  text-overflow: ellipsis;
}
#expandButton img {
  width: 12px;
  height: 12px;
}


#stageomschrijvingTextBox p {
  font-size: 14px;
}

.aftudeerRichtingTitel {
  font-size: 22px;
  font-weight: 500;
}

.flexEnd {
  display: flex;
  align-items: flex-end;
  justify-content: flex-end;
  margin-top: 30px;
  margin-right: 5%;
}

.red {
  background: red;
  height: 40vh;
  weight: 40vh;
}

.info {
  display: inline-block;
  border: black;
  background: white;
  color: black !important;
  padding-left: 5px;
  padding-right: 5px;
  border-radius: 5px;
  box-shadow: 0px 0px 5px 1px rgba(0, 0, 0, 0.55);
  position: absolute;
  margin-left: 10px;
  z-index: 500;
}

.edit {
  margin-left: 10px;
}

.edit img {
  margin: 0 10px 0 0;
}

h2 p {
  font-weight: normal;
  font-size: smaller;
}

.button--loading--detailsPage::after {
  content: "";
  width: 30vw;
  height: 30vw;
  margin: auto;
  border: 6px solid transparent;
  position: absolute;
  top: 18%;
  left: 35%;
  border-top-color: black;
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
#goedkeurenButton {
  margin-right: 15px;
}

.mailVenster {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: 
    'berichtenLijst berichtVenster'
    'berichtenLijst antwoordVenster';
  width: 90%;
  margin-left: 5%;
  margin-top: 30px;
  border: 2px solid #e5e5e5;
}
.berichtenLijst {
  grid-area: berichtenLijst;
  border-right: 2px solid #e5e5e5;
}
.berichtVenster {
  grid-area: berichtVenster;
  padding: 2vw;
  background: white;
}
.berichtInhoud {
  grid-area: berichtInhoud;
  font-size: 14px;
  overflow: auto;
  margin-top: 15px;
  height: 35vh;
  width: 56vw;
}
.antwoordVenster {
  grid-area: antwoordVenster;
  border-top: 1px solid #e5e5e5;
  padding: 2vw;
  position: relative;
  display: inline-block;
  height: 40vh;
  background: white;
}
#selecteerReviewerBox {
  background: black;
  color: white;
  width: 30vw;
  outline: none;
  border: 2px solid black;
  height: 30px;
}
.loading {
  position: absolute;
  background: black;
  color: white;
  font-size: 1vw;
  width: 10vw;
  height: 10vh;
  top: 45vh;
  left: 45vw;
  display: flex;
  align-items: center;
  justify-content: center;
}
.antwoord {
  color: black;
  outline: none;
  border: none;
  height: auto;
  width: 56vw;
  height: 30vh;
  resize: none;
}
.verzendKnop {
  position: absolute;
  bottom: 15px;
  right: 15px;
  color: white;
  background: black;
  height: 35px;
  width: 120px;
  border: none;
}
.verzendKnop:hover {
  background: #505050;
}
.pdfToevoegenCheckBox {
  position: absolute;
  bottom: 15px;
  left: 15px;
}
.afzender {
  color: #707070;
}
</style>
