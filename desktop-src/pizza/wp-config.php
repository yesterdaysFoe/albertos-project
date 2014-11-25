<?php
/**
 * The base configurations of the WordPress.
 *
 * This file has the following configurations: MySQL settings, Table Prefix,
 * Secret Keys, WordPress Language, and ABSPATH. You can find more information
 * by visiting {@link http://codex.wordpress.org/Editing_wp-config.php Editing
 * wp-config.php} Codex page. You can get the MySQL settings from your web host.
 *
 * This file is used by the wp-config.php creation script during the
 * installation. You don't have to use the web site, you can just copy this file
 * to "wp-config.php" and fill in the values.
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'pizza');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', '');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'g1P)!!*sS#:jzlks5N-Y|$d]F>?LzS6OP=kl,0W1eO{!,Y`nBli$`WMi_?K}L&SF');
define('SECURE_AUTH_KEY',  '&092Xs+~+X)+{9BI#Xml<+G$`o5TKHk5IS]yG^I6>mF70[KdMvi$H:E&o2LIs56/');
define('LOGGED_IN_KEY',    'lDE]QsD IB{$xF51;5(9] azY&aS^X([X$s]O0]u+9#PWr:v KP_ (3`scnqCK>?');
define('NONCE_KEY',        '$qfAi} l$kA8jbo(dZQiZ[iSFFA-[3,cPNc`,6NyolB.?>&f~(UB;XR=RPY*XM~@');
define('AUTH_SALT',        'o)#@?$)$.G|<2iQ`<bKO|[{g=D)Gz?(tI8 H$tNeR;44yWzVmgI~BerSsl%|(#S>');
define('SECURE_AUTH_SALT', 'bAU-k}Hx:x&2~v=Rvo*qKzTWNi~&~W{l2o31,EB__ZRsg:XuOqE@J{fvWewyoDU|');
define('LOGGED_IN_SALT',   '9UWNIpNb-f;-16H1e&WnVQ0-aj3+lGSv>di<yZNPRylVY6#Ef1$~B-0<HxY?D2j@');
define('NONCE_SALT',       '2R:.)wa+;@Ug:_iH-~&b+$)EZR2Xrak3<U0moLzyY(&yX;YAkdK[So*~k_;JAk74');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each a unique
 * prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'pizza';

/**
 * WordPress Localized Language, defaults to English.
 *
 * Change this to localize WordPress. A corresponding MO file for the chosen
 * language must be installed to wp-content/languages. For example, install
 * de_DE.mo to wp-content/languages and set WPLANG to 'de_DE' to enable German
 * language support.
 */
define('WPLANG', '');

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
