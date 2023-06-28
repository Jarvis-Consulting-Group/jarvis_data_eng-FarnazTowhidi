const express = require("express");
const router = express.Router();
const traderCtrl = require ("../../controller/api/traders")

router.get("/", traderCtrl.getAllTraders);
router.delete("/:id", traderCtrl.deleteTraders)



console.log ("this is a Router")

module.exports = router; 