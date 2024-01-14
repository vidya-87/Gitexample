$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/prouser/journey27.feature");
formatter.feature({
  "line": 2,
  "name": "Journey 27",
  "description": "",
  "id": "journey-27",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-27;prouser-submit-a-claim-as-passenger-in-bus",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "prouser enter all mandatory details for claim creation as \u0027\u003cinvolvement_type_v\u003e\u0027 and \u0027\u003cowner\u003e\u0027 and \u0027\u003cmultivrn\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "journey-27;prouser-submit-a-claim-as-passenger-in-bus;",
  "rows": [
    {
      "cells": [
        "involvement_type_v",
        "owner",
        "multivrn"
      ],
      "line": 10,
      "id": "journey-27;prouser-submit-a-claim-as-passenger-in-bus;;1"
    },
    {
      "cells": [
        "A passenger on a bus",
        "NO",
        "NO"
      ],
      "line": 11,
      "id": "journey-27;prouser-submit-a-claim-as-passenger-in-bus;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7498051600,
  "status": "passed"
});
formatter.before({
  "duration": 138800,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Prouser Submit a Claim as passenger in bus",
  "description": "",
  "id": "journey-27;prouser-submit-a-claim-as-passenger-in-bus;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "prouser logins into whiplash application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "prouser enter all mandatory details for claim creation as \u0027A passenger on a bus\u0027 and \u0027NO\u0027 and \u0027NO\u0027",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "claim is created for prouser",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.prouser_logins_into_whiplash_applicataion_using()"
});
formatter.result({
  "duration": 50058236300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A passenger on a bus",
      "offset": 59
    },
    {
      "val": "NO",
      "offset": 86
    },
    {
      "val": "NO",
      "offset": 95
    }
  ],
  "location": "ProUserActionsStepDefs.prouser_Enter_All_Mandatory_Details_For_Claim_Creation(String,String,String)"
});
formatter.result({
  "duration": 465149517500,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.claim_Is_Created()"
});
formatter.result({
  "duration": 44391913500,
  "status": "passed"
});
formatter.after({
  "duration": 1835905600,
  "status": "passed"
});
formatter.before({
  "duration": 5717792100,
  "status": "passed"
});
formatter.before({
  "duration": 163600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Compensator receives claim and claim liability sent to TPA",
  "description": "",
  "id": "journey-27;compensator-receives-claim-and-claim-liability-sent-to-tpa",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Claim  is sent to the compensator",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "compensator receives claim and send to TPA",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "claims acceptance and liability decision is now sent to TPA",
  "keyword": "Then "
});
formatter.match({
  "location": "CompensatorStepDefs.claim_is_sent_to_the_compensator()"
});
formatter.result({
  "duration": 43419165300,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.compensator_receives_claim_send_TPA()"
});
formatter.result({
  "duration": 36824646500,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claims_acceptance_liability_decision_sent_TPA()"
});
formatter.result({
  "duration": 10841956500,
  "status": "passed"
});
formatter.after({
  "duration": 1833968000,
  "status": "passed"
});
formatter.before({
  "duration": 5824847200,
  "status": "passed"
});
formatter.before({
  "duration": 118700,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "TPA accepts full liability",
  "description": "",
  "id": "journey-27;tpa-accepts-full-liability",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Login as TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "TPA accepts full liability",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "claims acceptance and liability information is passed to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.login_As_TPA()"
});
formatter.result({
  "duration": 38364592300,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.tpa_accepts_full_liability()"
});
formatter.result({
  "duration": 94900659100,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.claims_Acceptance_Denied_Liability_passedto_claimant()"
});
formatter.result({
  "duration": 10395014400,
  "status": "passed"
});
formatter.after({
  "duration": 1813269900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Claimant add losses and fee",
  "description": "",
  "id": "journey-27;claimant-add-losses-and-fee",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "claim liability is accepted",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "\u0027\u003cclaimant\u003e\u0027 add losses and fee",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "claim will proceed to upload medical reports",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "journey-27;claimant-add-losses-and-fee;",
  "rows": [
    {
      "cells": [
        "claimant"
      ],
      "line": 28,
      "id": "journey-27;claimant-add-losses-and-fee;;1"
    },
    {
      "cells": [
        "prouser"
      ],
      "line": 29,
      "id": "journey-27;claimant-add-losses-and-fee;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5717736700,
  "status": "passed"
});
formatter.before({
  "duration": 84900,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Claimant add losses and fee",
  "description": "",
  "id": "journey-27;claimant-add-losses-and-fee;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "claim liability is accepted",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "\u0027prouser\u0027 add losses and fee",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "claim will proceed to upload medical reports",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_liability_accepted()"
});
formatter.result({
  "duration": 47533877000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimants_add_losses_fee(String)"
});
formatter.result({
  "duration": 99587498200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.proceed_to_upload_medical_reports()"
});
formatter.result({
  "duration": 12424421500,
  "status": "passed"
});
formatter.after({
  "duration": 1693114400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 32,
  "name": "Prouser  uploads medical Report",
  "description": "",
  "id": "journey-27;prouser--uploads-medical-report",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 33,
  "name": "\u0027\u003cclaimant\u003e\u0027 receives claim",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "claimant uploads medical report at \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.examples({
  "line": 37,
  "name": "",
  "description": "",
  "id": "journey-27;prouser--uploads-medical-report;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 38,
      "id": "journey-27;prouser--uploads-medical-report;;1"
    },
    {
      "cells": [
        "prouser",
        "Pending-Medical"
      ],
      "line": 39,
      "id": "journey-27;prouser--uploads-medical-report;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5237680800,
  "status": "passed"
});
formatter.before({
  "duration": 130000,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Prouser  uploads medical Report",
  "description": "",
  "id": "journey-27;prouser--uploads-medical-report;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "\u0027prouser\u0027 receives claim",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "claimant uploads medical report at \u0027Pending-Medical\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "report is uploaded and sent to compensator",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.user_Receives_Claim(String)"
});
formatter.result({
  "duration": 48736060100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pending-Medical",
      "offset": 36
    }
  ],
  "location": "ProUserActionsStepDefs.medical_report_prouser(String)"
});
formatter.result({
  "duration": 202740873400,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.report_sent_to_compensator()"
});
formatter.result({
  "duration": 9428225600,
  "status": "passed"
});
formatter.after({
  "duration": 1757125700,
  "status": "passed"
});
formatter.before({
  "duration": 5344633000,
  "status": "passed"
});
formatter.before({
  "duration": 103400,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "TPA disputes causation at offer and decides not to make any offer",
  "description": "",
  "id": "journey-27;tpa-disputes-causation-at-offer-and-decides-not-to-make-any-offer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "claimant requests offer to TPA",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "TPA disputes causation at offer",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "claim is sent to claimant",
  "keyword": "Then "
});
formatter.match({
  "location": "TPAStepDefs.claimant_requests_offer()"
});
formatter.result({
  "duration": 39796309600,
  "status": "passed"
});
formatter.match({
  "location": "TPAStepDefs.compensator_disputes_causation_at_offer()"
});
formatter.result({
  "duration": 79249175800,
  "status": "passed"
});
formatter.match({
  "location": "CompensatorStepDefs.claim_sent_to_claimant()"
});
formatter.result({
  "duration": 21452256900,
  "status": "passed"
});
formatter.after({
  "duration": 1612312300,
  "status": "passed"
});
formatter.before({
  "duration": 5220447100,
  "status": "passed"
});
formatter.before({
  "duration": 61600,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "Claimant accepts the decision and no offer is made",
  "description": "",
  "id": "journey-27;claimant-accepts-the-decision-and-no-offer-is-made",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 47,
  "name": "TPA has disputed causation for prouser",
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "Prouser accepts the dispute causation no offer",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "claim moves to Resolved-NoOffer",
  "keyword": "Then "
});
formatter.match({
  "location": "ProUserActionsStepDefs.compensator_has_disputed_causation()"
});
formatter.result({
  "duration": 46044605200,
  "status": "passed"
});
formatter.match({
  "location": "ProUserActionsStepDefs.mibpro_accepts_the_dispute_no_offer()"
});
formatter.result({
  "duration": 45049944200,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_moves_to_resolved_no_offer()"
});
formatter.result({
  "duration": 12690291000,
  "status": "passed"
});
formatter.after({
  "duration": 1667317700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 51,
  "name": "The claim is moved to \u0027Resolved-NoOffer\u0027",
  "description": "",
  "id": "journey-27;the-claim-is-moved-to-\u0027resolved-nooffer\u0027",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 52,
  "name": "\u0027\u003cclaimant\u003e\u0027 goes to court",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "prouser claim status is \u0027\u003cstatus\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "claim is resolved",
  "keyword": "Then "
});
formatter.examples({
  "line": 55,
  "name": "",
  "description": "",
  "id": "journey-27;the-claim-is-moved-to-\u0027resolved-nooffer\u0027;",
  "rows": [
    {
      "cells": [
        "claimant",
        "status"
      ],
      "line": 56,
      "id": "journey-27;the-claim-is-moved-to-\u0027resolved-nooffer\u0027;;1"
    },
    {
      "cells": [
        "prouser",
        "Resolved-NoOffer"
      ],
      "line": 57,
      "id": "journey-27;the-claim-is-moved-to-\u0027resolved-nooffer\u0027;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4691821500,
  "status": "passed"
});
formatter.before({
  "duration": 113100,
  "status": "passed"
});
formatter.scenario({
  "line": 57,
  "name": "The claim is moved to \u0027Resolved-NoOffer\u0027",
  "description": "",
  "id": "journey-27;the-claim-is-moved-to-\u0027resolved-nooffer\u0027;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@prouser"
    }
  ]
});
formatter.step({
  "line": 52,
  "name": "\u0027prouser\u0027 goes to court",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "prouser claim status is \u0027Resolved-NoOffer\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "claim is resolved",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "prouser",
      "offset": 1
    }
  ],
  "location": "ClaimantActionsStepDefs.claimant_goes_to_court(String)"
});
formatter.result({
  "duration": 37992523700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Resolved-NoOffer",
      "offset": 25
    }
  ],
  "location": "ProUserActionsStepDefs.claim_goes_to_dispute_at_court(String)"
});
formatter.result({
  "duration": 25760086500,
  "status": "passed"
});
formatter.match({
  "location": "ClaimantActionsStepDefs.claim_is_resolved()"
});
formatter.result({
  "duration": 11065610000,
  "status": "passed"
});
formatter.after({
  "duration": 1686117400,
  "status": "passed"
});
});