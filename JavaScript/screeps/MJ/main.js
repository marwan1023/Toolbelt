var roleHarvester = require('role.harvester');
var roleBuilder = require('role.builder');
var roleUpgrader = require('role.upgrader');


module.exports.loop = function () {

    var tower = Game.getObjectById('TOWER_ID');
    if(tower) {
        var closestDamagedStructure = tower.pos.findClosestByRange(FIND_STRUCTURES, {
            filter: (structure) => structure.hits < structure.hitsMax
        });
        if(closestDamagedStructure) {
            tower.repair(closestDamagedStructure);
        }

        var closestHostile = tower.pos.findClosestByRange(FIND_HOSTILE_CREEPS);
        if(closestHostile) {
            tower.attack(closestHostile);
        }
    }


    // for(var name in Game.rooms) {
    //     console.log('Room "'+name+'" has '+Game.rooms[name].energyAvailable+' energy');
    // }
    
    for(var name in Memory.creeps) {
        if(!Game.creeps[name]) {
            delete Memory.creeps[name];
            console.log('Clearing non-existing creep memory:', name);
        }
    }

    var harvesters = _.filter(Game.creeps, (creep) => creep.memory.role == 'harvester');
    var upgraders = _.filter(Game.creeps, (creep) => creep.memory.role == 'upgrader');
    
     if(harvesters.length < 2) {
         var newName = Game.spawns['MJSpawn1'].createCreep([WORK,CARRY,MOVE], undefined, {role: 'harvester'});
         console.log('Spawning new harvester: ' + newName);
     }
    
    if(upgraders.length < 2) {
        var newName = Game.spawns['MJSpawn1'].createCreep([WORK,CARRY,MOVE], undefined, {role: 'upgrader'});
        console.log('Spawning new upgrader: ' + newName);
    }
    
    if(Game.spawns['MJSpawn1'].spawning) {
        var spawningCreep = Game.creeps[Game.spawns['MJSpawn1'].spawning.name];
        Game.spawns['MJSpawn1'].room.visual.text(
            '🛠️' + spawningCreep.memory.role,
            Game.spawns['MJSpawn1'].pos.x + 1,
            Game.spawns['MJSpawn1'].pos.y,
            {align: 'left', opacity: 0.8});
    }

   
    for(var name in Game.creeps) {
        var creep = Game.creeps[name];
        console.log(creep.memory.role);
        if(creep.memory.role == 'harvester') {
            roleHarvester.run(creep);
        }
        if(creep.memory.role == 'upgrader') {
            roleUpgrader.run(creep);
        }
        if(creep.memory.role == 'builder') {
            roleBuilder.run(creep);
        }
    }
}