'use strict';

import DateFactoryPlugin from './lib/datefactory.js';

let DateFactory = {

    now: function() {
        return new Promise(function(resolve,reject) {

            DateFactoryPlugin.now(function(args) {
                return resolve(args);
            }, function(err) {
                return reject(err);
            });

        }.bind(this));
    }

};

module.exports = DateFactory;
