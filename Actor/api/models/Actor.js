/**
 * Actor.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
	nombres:'string',
	apellidos:'string',
	fechaNacimiento:'string',
	numeroPeliculas:'string',
	retirado:'string',
	pelicula:{
		collection:'pelicula',
		via:'owner'
	}
  }

};

