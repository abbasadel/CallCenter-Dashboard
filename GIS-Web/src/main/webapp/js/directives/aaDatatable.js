'use strict';

//code from http://jsfiddle.net/zdam/7kLFU/

myApp.directive('aaDatatable', function($http) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            // apply DataTable options, use defaults if none specified by user
            var options = {};
            if (attrs.aaDatatable.length > 0) {
                options = scope.$eval(attrs.aaDatatable);
            } else {
                options = {
                    "sDom": "<'dt-top-row'Tlf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
                    "oTableTools": {
                        "aButtons": ["copy", "print", {
                                "sExtends": "collection",
                                "sButtonText": 'Save <span class="caret" />',
                                "aButtons": ["csv", "xls", "pdf"]
                            }],
                        "sSwfPath": "js/libs/plugin/datatables/media/swf/copy_csv_xls_pdf.swf"
                    },
                    "fnInitComplete": function(oSettings, json) {
                        element.closest('#dt_table_tools_wrapper').find('.DTTT.btn-group').addClass('table_tools_group').children('a.btn').each(function() {
                            element.addClass('btn-sm btn-default');
                        });
                    }
                }
            }

            // Tell the dataTables plugin what columns to use
            // We can either derive them from the dom, or use setup from the controller           
            var explicitColumns = [];
            element.find('th').each(function(index, elem) {
                explicitColumns.push($(elem).text());
            });
            if (explicitColumns.length > 0) {
                options["aoColumns"] = explicitColumns;
            } else if (attrs.aoColumns) {
                options["aoColumns"] = scope.$eval(attrs.aoColumns);
            }

            // aoColumnDefs is dataTables way of providing fine control over column config
            if (attrs.aoColumnDefs) {
                options["aoColumnDefs"] = scope.$eval(attrs.aoColumnDefs);
            }

            if (attrs.fnRowCallback) {
                options["fnRowCallback"] = scope.$eval(attrs.fnRowCallback);
            }

            // apply the plugin
            var dataTable = element.dataTable(options);



            // watch for any changes to our data, rebuild the DataTable
            scope.$watch(attrs.aaData, function(value) {
                var val = value || null;
                if (val) {
                    dataTable.fnClearTable();
                    dataTable.fnAddData(scope.$eval(attrs.aaData));
                }
            });


        }
    };
});