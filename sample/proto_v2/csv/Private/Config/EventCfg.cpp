/**
 * This file is generated by xresloader 2.11.0-rc3, please don't edit it.
 * You can find more information about this xresloader on https://xresloader.atframe.work/ .
 * If there is any problem, please find or report issues on https://github.com/xresloader/xresloader/issues .
 */
// Test event_cfg with oneof fields

#include "Config/EventCfg.h"



UEventCfgHelper::UEventCfgHelper() : Super()
{
    UEventCfgHelper::ClearRow(this->Empty);
    this->DataTable = nullptr;
    this->EnableDefaultLoader = true;
}

void UEventCfgHelper::OnReload()
{
    // TODO Rebuild Index
}

void UEventCfgHelper::SetLoader(TSharedPtr<ConstructorHelpers::FObjectFinder<UDataTable> > NewLoader)
{
    this->Loader = NewLoader;
    if (this->Loader && this->Loader->Succeeded())
    {
        this->DataTable = this->Loader->Object;
        this->DataTable->OnDataTableChanged().AddUObject(this, &UEventCfgHelper::OnReload);
        OnReload();
    }
    else
    {
        this->DataTable = nullptr;
    }
}

void UEventCfgHelper::InitializeDefaultLoader() const
{
    if (!this->EnableDefaultLoader) {
        return;
    }
    const_cast<UEventCfgHelper*>(this)->EnableDefaultLoader = false;
    const_cast<UEventCfgHelper*>(this)->SetLoader(MakeShareable(new ConstructorHelpers::FObjectFinder<UDataTable>(TEXT("DataTable'/Game/Config/EventCfg'"))));
}

void UEventCfgHelper::DisableDefaultLoader()
{
    this->EnableDefaultLoader = false;
}

FName UEventCfgHelper::GetRowName(int32 Id, int32 Process)
{
    return *FString::Printf(TEXT("%lld"), static_cast<long long>(Id) * 100 + static_cast<long long>(Process));
}

FName UEventCfgHelper::GetDataRowName(int32 Id, int32 Process) const
{
    return UEventCfgHelper::GetRowName(Id, Process);
}

FName UEventCfgHelper::GetTableRowName(const FEventCfg& TableRow) const
{
    return GetDataRowName(TableRow.Id, TableRow.Process);
}

const FEventCfg& UEventCfgHelper::GetDataRowByName(const FName& Name, bool& IsValid) const
{
    IsValid = false;
    if (!this->DataTable && this->EnableDefaultLoader && !this->Loader.IsValid()) {
        this->InitializeDefaultLoader();
    }
    if (!this->DataTable) {
        return this->Empty;
    }

    FString Context;
    FEventCfg* LookupRow = DataTable->FindRow<FEventCfg>(Name, Context, false);
    if (!LookupRow) {
        return this->Empty;
    };

    IsValid = true;
    return *LookupRow;
}

const FEventCfg& UEventCfgHelper::GetDataRowByKey(int32 Id, int32 Process, bool& IsValid) const
{
    return GetDataRowByName(GetDataRowName(Id, Process), IsValid);
}

bool UEventCfgHelper::ForeachRow(TFunctionRef<void (const FName& Key, const FEventCfg& Value)> Predicate) const
{
    if (!this->DataTable && this->EnableDefaultLoader && !this->Loader.IsValid()) {
        this->InitializeDefaultLoader();
    }
    if (!this->DataTable) {
        return false;
    }

    FString Context;
    this->DataTable->ForeachRow(Context, Predicate);
    return true;
}

UDataTable* UEventCfgHelper::GetRawDataTable(bool& IsValid) const
{
    IsValid = false;
    if (!this->DataTable && this->EnableDefaultLoader && !this->Loader.IsValid()) {
        this->InitializeDefaultLoader();
    }
    if (!this->DataTable) {
        return NULL;
    }

    IsValid = true;
    return this->DataTable;
}

void UEventCfgHelper::ClearRow(FEventCfg& TableRow)
{
    TableRow.Name = TEXT("");
    TableRow.Id = 0;
    TableRow.Process = 0;
    TableRow.Rule_RuleId = 0;
    TableRow.Rule_RuleParam = 0;
    TableRow.SpecifyField_NestedEnumType = 0;
}

void UEventCfgHelper::ClearDataRow(FEventCfg& TableRow) const
{
    UEventCfgHelper::ClearRow(TableRow);
}

