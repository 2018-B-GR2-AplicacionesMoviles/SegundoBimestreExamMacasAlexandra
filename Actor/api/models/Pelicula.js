/**
 * Pelicula.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
	identificadorPelicula:'string',
	  nombre:'string',
	  anioLanzamiento:'string',
	  rating:'string',
	  owner: {
		model:'actor'
	  }

      }

};

