<?php
/**
 * Sidebar Template
 *
 * If a `primary` widget area is active and has widgets, display the sidebar.
 *
 * @package WooFramework
 * @subpackage Template
 */
	global $woo_options;
	
	$layout = $woo_options['woo_layout'];
	// Cater for custom portfolio gallery layout option.
	if ( is_tax( 'portfolio-gallery' ) || is_post_type_archive( 'portfolio' ) ) {
		$portfolio_gallery_layout = get_option( 'woo_portfolio_layout' );
		
		if ( $portfolio_gallery_layout != '' ) { $layout = $portfolio_gallery_layout; }
	}
	
	if ( $layout != 'one-col' ) {

		if ( woo_active_sidebar( 'primary' ) ) {
	
			woo_sidebar_before();
?>
<div id="sidebar">

	<div id="text-adsense" class="widget widget_text">
	
		<h3>Patrocinio</h3>
    
    <div id="text-adsense-center">
	

		<script type="text/javascript"><!--
google_ad_client = "ca-pub-6878955411965127";
/* networld */
google_ad_slot = "6009638749";
google_ad_width = 200;
google_ad_height = 200;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
    
    </div><!-- closer text-adsense-center DIV -->

	</div><!-- closer text-adsense DIV -->
	
	<?php
		woo_sidebar_inside_before();
		woo_sidebar('primary');
		woo_sidebar_inside_after();
	?>
</div><!-- /#sidebar -->
<?php
			woo_sidebar_after();
		} // End IF Statement
	} // End IF Statement
?>