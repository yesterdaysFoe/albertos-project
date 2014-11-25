<?php global $woo_options; ?>

	<?php
		$total = $woo_options[ 'woo_footer_sidebars' ]; if (!isset($total)) $total = 4;
		if ( ( woo_active_sidebar( 'footer-1') ||
			   woo_active_sidebar( 'footer-2') ||
			   woo_active_sidebar( 'footer-3') ||
			   woo_active_sidebar( 'footer-4') ) && $total > 0 ) :

  	?>
	<div id="footer-widgets" class="col-full col-<?php echo $total; ?>">

		<?php $i = 0; while ( $i < $total ) : $i++; ?>
			<?php if ( woo_active_sidebar( 'footer-'.$i) ) { ?>

		<div class="block footer-widget-<?php echo $i; ?>">
        	<?php woo_sidebar( 'footer-'.$i); ?>
		</div>

	        <?php } ?>
		<?php endwhile; ?>

		<div class="fix"></div>

	</div><!-- /#footer-widgets  -->
    <?php endif; ?>
    
    <?php woo_content_after(); ?>
    
  </div><!--/#container-->

	<div id="footer" class="col-full">

		<div id="copyright" class="col-left">
		<?php if( $woo_options[ 'woo_footer_left' ] == 'true' ) {

				echo "ALBERTO'S PIZZA Online © 2014. All Rights Reserved";

		} else { ?>
			<p>ALBERTO'S PIZZA Online © 2014. All Rights Reserved</p>
		<?php } ?>
		</div>

		<div id="credit" class="col-right">
        <?php if( $woo_options[ 'woo_footer_right' ] == 'true' ){

        	echo "ALBERTO'S PIZZA Online © 2014. All Rights Reserved";

		}  ?>
		</div>

	</div><!-- /#footer  -->

</div><!-- /#wrapper -->
<?php wp_footer(); ?>
<?php woo_foot(); ?>
</body>
</html>